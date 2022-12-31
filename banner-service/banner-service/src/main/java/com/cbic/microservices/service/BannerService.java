package com.cbic.microservices.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cbic.microservices.dto.Banner;

public interface BannerService {

	public Banner saveBanner(MultipartFile multipartFile, String description, Integer priority, Date startDate, Date endDate);
	public List<Banner> getAllBanners();
}
