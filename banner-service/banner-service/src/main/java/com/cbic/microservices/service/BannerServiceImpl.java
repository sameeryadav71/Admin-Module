package com.cbic.microservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cbic.microservices.dto.Banner;
import com.cbic.microservices.entity.CbicContentMst;
import com.cbic.microservices.entity.CbicDocMst;
import com.cbic.microservices.entity.RequestActionDetail;
import com.cbic.microservices.entity.RequestDetails;
import com.cbic.microservices.util.BannerUtil;

@Service
public class BannerServiceImpl implements BannerService {
	
	@Autowired
	private RequestDetailsService requestDetailsService;
	
	@Autowired
	private RequestActionDetailService requestActionDetailService;
	
	@Autowired
	private CbicContentMstService cbicContentMstService;
	
	@Autowired
	private CbicDocMstService cbicDocMstService;

	@Autowired
	private ImageService imageService;

	@Value("${project.image}")
	private String path;


	@Override
	public List<Banner> getAllBanners() {
		//saveCbicContentMst
		List<Banner> banners = new ArrayList<>();
		List<CbicContentMst> cbicContentMsts = new ArrayList<>();
		//List<RequestDetails> requestDetails = null;
		try {
			//requestDetails = requestDetailsService.getAllRequestDetails();
			cbicContentMsts = cbicContentMstService.getAllCbicContentMst();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null != cbicContentMsts && !cbicContentMsts.isEmpty()) {
			for (CbicContentMst cbicContentMst : cbicContentMsts) {
				Banner banner = BannerUtil.saveCbicContentMst(cbicContentMst);
				banners.add(banner);
			}
		}
//		if(null != requestDetails && !requestDetails.isEmpty())
//		{
//			for (RequestDetails requestDetail : requestDetails) {
//				Banner banner = new Banner();
//				banner.setRequestDetails(requestDetail);
//				try {
//					banner.setCbicContentMst(cbicContentMstService.getCbicContentMstByRequestId(requestDetail.getRequestNo()));
//					banner.setCbicDocMst(cbicDocMstService.getCbicDocMstByRequestId(requestDetail.getRequestNo()));
//					banner.setRequestActionDetail(requestActionDetailService.getRequestActionDetailByRequestId(requestDetail.getRequestNo()));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				banners.add(banner);
//			}
//		}		
		return banners;
	}

	//@Override
	public Banner deleteBanner(Long bannerId) {
		// TODO Auto-generated method stub
//		Optional<Banner> optional = bannerRepository.findById(bannerId);
//		if (optional.isPresent()) {
//			bannerRepository.deleteById(bannerId);
//			return optional.get();
//		}
		return null;
	}

	@Override
	@Transactional
	public Banner saveBanner(MultipartFile multipartFile, String description, Integer priority, Date startDate, Date endDate) {
		Banner banner = new Banner();
		RequestDetails requestDetails = null;
		RequestActionDetail requestActionDetail = null;
		CbicContentMst cbicContentMst = null;
		CbicDocMst cbicDocMst = null;
		try {
				banner.setBannerDesription(description);
				banner.setBannerName(multipartFile.getOriginalFilename());
				banner.setPriority(priority);
				banner.setCreatedDate(new Date());
				banner.setImagePath(path+multipartFile.getOriginalFilename());
				banner.setStartDate(startDate);
				banner.setEndDate(endDate);
				imageService.uploadImge(path, multipartFile);
				//setting constants for banner
				banner = BannerUtil.getBannerDeatils(banner);
				requestDetails = requestDetailsService.saveRequestDetails(banner.getRequestDetails());
				//set requestDetails object in banner object so the we can get requestId for other entities
				banner.setRequestDetails(requestDetails);
				banner = BannerUtil.getBannerDeatils(banner);
				requestActionDetail = requestActionDetailService.saveRequestActionDetail(banner.getRequestActionDetail());
				cbicContentMst = cbicContentMstService.saveCbicContentMst(banner.getCbicContentMst());
				cbicDocMst = cbicDocMstService.saveCbicDocMst(banner.getCbicDocMst());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(requestActionDetail!=null && null!= requestDetails && null!= cbicContentMst && null!= cbicDocMst) {
			banner.setRequestDetails(requestDetails);
			banner.setRequestActionDetail(requestActionDetail);
			banner.setCbicContentMst(cbicContentMst);
			banner.setCbicDocMst(cbicDocMst);
			return banner;
		}
		return null;
	}

}
