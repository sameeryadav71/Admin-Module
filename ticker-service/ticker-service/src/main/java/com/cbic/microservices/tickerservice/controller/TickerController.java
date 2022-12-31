package com.cbic.microservices.tickerservice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

import com.cbic.microservices.tickerservice.config.Constants;
import com.cbic.microservices.tickerservice.config.CryptoEncDec;
import com.cbic.microservices.tickerservice.config.TickerConfiguration;
import com.cbic.microservices.tickerservice.dto.CbicContentMasterDTO;
import com.cbic.microservices.tickerservice.dto.RequestDetailsDTO;
import com.cbic.microservices.tickerservice.dto.WorkflowMasterDTO;
import com.cbic.microservices.tickerservice.exception.RequestNotValid;
import com.cbic.microservices.tickerservice.exception.SaveFailureException;
import com.cbic.microservices.tickerservice.exception.TickerDataNotFoundException;
import com.cbic.microservices.tickerservice.model.AddTickerRequest;
import com.cbic.microservices.tickerservice.model.Ticker;
import com.cbic.microservices.tickerservice.model.TickerDetailBean;
import com.cbic.microservices.tickerservice.service.RequestDetailsService;
import com.cbic.microservices.tickerservice.service.TickerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RefreshScope
@RestController
public class TickerController {

	@Autowired
	TickerService tickerService;
	
	@Autowired
	private TickerConfiguration loginConfiguration;
	
	@Autowired
	private RequestDetailsService requestDetailsService;
	
	@Qualifier("jdbcCbicProduction")
	@Autowired
	JdbcTemplate jdbcCbicProductionTemplate;
	
	@Qualifier("jdbcAdminModule")
	@Autowired
	JdbcTemplate jdbcAdminModuleTemplate;
	
	@GetMapping("/getAllTickers")
	public ResponseEntity<List<Ticker>> getAllTickers(){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-control-allow-origin", "*");
		List<Ticker> response= jdbcCbicProductionTemplate.query("select * from cbic_content_mst where content_type_id = 1", 
				BeanPropertyRowMapper.newInstance(Ticker.class), null);
		return new ResponseEntity(response, responseHeaders, HttpStatus.OK);
	} 
	
	@PostMapping(value = "/addNewTicker", consumes = { MediaType.APPLICATION_JSON_VALUE,
													   MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity addNewTicker(@RequestPart("tickerAddRequest") String addRequest, @RequestPart("files") MultipartFile[] files) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-control-allow-origin", "*");
		String randomId = CryptoEncDec.getSaltString();
		if(null == addRequest || "".compareTo(addRequest) == 0)throw new TickerDataNotFoundException();
		
		AddTickerRequest tickerAddRequst = new AddTickerRequest();
		ObjectMapper mapper = new ObjectMapper();
		try {
			tickerAddRequst = mapper.readValue(addRequest, AddTickerRequest.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RequestNotValid();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RequestNotValid();
		}
		
		
		try {
			WorkflowMasterDTO workflowMasterDTO = (WorkflowMasterDTO) jdbcAdminModuleTemplate.queryForObject(
					"Select * from workflow_mst where workflow_name = ?", 
					new Object[]{Constants.NEW_CONTENT_UPLOAD_WORKFLOW}, 
					new BeanPropertyRowMapper(WorkflowMasterDTO.class));
			tickerAddRequst.setWorkflowId(workflowMasterDTO.getWorkflowId());
			
			RequestDetailsDTO requestDetailsDTO = requestDetailsService.saveRequest(tickerAddRequst, files, jdbcAdminModuleTemplate);
			//CbicContentMasterDTO cbicContentMasterDTO = requestDetailsService.saveContentMaster(tickerAddRequst, files, jdbcAdminModuleTemplate, requestDetailsDTO);
			
			for(TickerDetailBean fileDetailBean : tickerAddRequst.getDetailBean()) {
				File destinationPath = new File(loginConfiguration.getADMIN_DOC_SERVER_PATH());
				if(!destinationPath.exists()) {
					destinationPath.mkdir();
				}
				MessageDigest messageDigest = null;
				try {
					messageDigest = MessageDigest.getInstance(loginConfiguration.getMSG_DIGEST_ALGO());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new com.cbic.microservices.tickerservice.exception.NoSuchAlgorithmException();
				}
				try {
					String checksum = generateFileChecksum(messageDigest, destinationPath);
					System.out.println("<<<<>>>> File name : "+fileDetailBean.getFileName_en()+", <<<<>>>> Checksum : "+checksum);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new com.cbic.microservices.tickerservice.exception.IOException();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SaveFailureException();
		}
		return ResponseEntity.ok().headers(responseHeaders).build();
	}
	
	private static String generateFileChecksum(MessageDigest digest, File file) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		try
		{
			// Get file input stream for reading the file content
			FileInputStream fis = new FileInputStream(file);

			// Create byte array to read data in chunks
			byte[] byteArray = new byte[1024];
			int bytesCount = 0;

			// Read file data and update in message digest
			while ((bytesCount = fis.read(byteArray)) != -1) {
				digest.update(byteArray, 0, bytesCount);
			}
			;

			// close the stream; We don't need it now.
			fis.close();

			// Get the hash's bytes
			byte[] bytes = digest.digest();

			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
//			logger.error("Error in generating hash code for file",e);
//			logger.error(e.getMessage());
		}
		
		// return complete hash
		return sb.toString();
	}
	
}
