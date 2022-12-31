package com.cbic.microservices.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cbic.microservices.dto.Banner;
import com.cbic.microservices.service.BannerService;
import com.cbic.microservices.service.ImageService;
import com.cbic.microservices.util.ImageResponse;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@Autowired
	private ImageService imageService;

	@Value("${project.image}")
	private String path;

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveBanner(@RequestPart("image") MultipartFile image,
			@RequestParam("description") String description,
			@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
			@RequestParam(name = "priority", required = false) Integer priority) {
		Banner banner = null;
		try {
			banner = bannerService.saveBanner(image, description, priority, startDate, endDate);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ImageResponse(null, "Banner not uploaded"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (banner != null) {
			return new ResponseEntity<>(banner, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(new ImageResponse(image.getOriginalFilename(),
					"Banner already exists please choose different image!!"), HttpStatus.OK);

	}

	@GetMapping("/getAllBanners")
	public List<Banner> getAllBanners() {
		List<Banner> banners = null;
		try {
			banners = bannerService.getAllBanners();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return banners;

	}

	@GetMapping(value = "/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void imageDownload(@PathVariable("imageName") String imageName, HttpServletResponse httpServletResponse)
			throws IOException {
		InputStream inputStream = this.imageService.getResource(path, imageName);
		httpServletResponse.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
	}
}
