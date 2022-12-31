package com.cbic.microservices.tickerservice.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cbic.microservices.tickerservice.config.Constants;
import com.cbic.microservices.tickerservice.dto.RequestDetailsDTO;
import com.cbic.microservices.tickerservice.exception.SaveFailureException;
import com.cbic.microservices.tickerservice.model.AddTickerRequest;
import com.cbic.microservices.tickerservice.repository.RequestDetailsRepository;
import com.cbic.microservices.tickerservice.repository.WorkflowMasterRepository;

@Service
public class RequestDetailsService {
	
	@Autowired
	private RequestDetailsRepository requestDetailsRepository;
	
	@Autowired
	private WorkflowMasterRepository workflowMasterRepository;
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public RequestDetailsDTO saveRequest(AddTickerRequest tickerAddRequst, MultipartFile[] files, JdbcTemplate jdbcAdminModuleTemplate) {
		try {
			Timestamp timestamp = new Timestamp(new Date().getTime());
			jdbcAdminModuleTemplate.update(
				      "INSERT INTO request_details ("
				      + "request_type, "
				      + "description, "
				      + "content_type_id,"
				      + "content_id, "
				      + "workflow_level, "
				      + "requested_by, "
				      + "requested_on,"
				      + "updated_by, "
				      + "updated_on, "
				      + "request_status, "
				      + "workflow_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				      tickerAddRequst.getRequestType(), 
				      tickerAddRequst.getDescription(), 
				      tickerAddRequst.getContentTypeId(), 
				      0,
				      0,
				      tickerAddRequst.getUserSSOId(),
				      timestamp,
				      tickerAddRequst.getUserSSOId(),
				      timestamp,
				      Constants.PENDING,
				      tickerAddRequst.getWorkflowId());
			RequestDetailsDTO requestDetailsDTO = (RequestDetailsDTO) jdbcAdminModuleTemplate.queryForObject(
					"select * from request_details where request_no = (SELECT LAST_INSERT_ID())",
		             new BeanPropertyRowMapper(RequestDetailsDTO.class));
			return requestDetailsDTO;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SaveFailureException();
		}
	}

	/*public CbicContentMasterDTO saveContentMaster(AddTickerRequest tickerAddRequst, MultipartFile[] files,
			JdbcTemplate jdbcTemplate, RequestDetailsDTO requestDetailsDTO) {
		// TODO Auto-generated method stub
		Timestamp timestamp = new Timestamp(new Date().getTime());
		jdbcTemplate.update(
				"INSERT INTO cbic_content_mst "
				+ "( "	+ "is_active, "	+ "order_id, "+ "created_dt, "+ "updated_dt, "
				+ "created_by, "+ "version_no, "+ "is_published, "+ "publish_dt, "
				+ "is_archived, "+ "archive_dt, "+ "parent_id, "+ "tax_id, "+ "location_id, "
				+ "title_en, "+ "title_hi, "+ "info_en, "+ "info_hi, "+ "ref_number, "+ "path, "
				+ "content_dt, "+ "ref_dt_1, "+ "ref_dt_2, "+ "expiry_dt, "+ "year, "+ "content_type_id, "
				+ "request_id) "
				+ "VALUES "
				+ "( "
				+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "
				+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "
				+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "
				+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "+ "?, "
				+ "?, "+ "?)",
				Constants.IS_ACTIVE_YES,
				ORDER_ID, //TO BE CHANGED priority
				timestamp,
				timestamp,
				tickerAddRequst.getUserSSOId(),
				VERSION_NO, //TO BE CHANGED
				PARENT_ID,
				TAX_ID,
				LOCATION_ID,
				TITLE_EN,
				TITLE_HI,
				INFO_EN,
				INFO_HI;
				REF_NUMBER,
				PATH,
				CONTENT_DT,
				REF_DT_1,
				REF_DT_2,
				EXP_DATE,
				YEAR,
				CONTENT_TYPE_ID,
				requestDetailsDTO.getRequestNo();
				);
		return null;
	}*/

	
}
