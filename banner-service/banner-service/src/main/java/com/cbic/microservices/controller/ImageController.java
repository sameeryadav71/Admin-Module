package com.cbic.microservices.controller;
//package com.cbic.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.cbic.entity.Banner;
//import com.cbic.service.ImageService;
//import com.cbic.util.ImageResponse;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//@RestController
//@RequestMapping("/image")
//public class ImageController {
//
//	@Autowired
//	private ImageService imageService;
//	
//	@Value("${project.image}")
//	private String path;
//	
//	@PostMapping("/upload")
//	public ResponseEntity<ImageResponse> imageUpload(@RequestPart("image")MultipartFile image, @RequestPart("description") String description, @RequestPart("banner")Banner banner){
//		String name = null;
//		try {
//			name = this.imageService.uploadImge(path, image, description);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			return new ResponseEntity<>(new ImageResponse(null, "Image not uploaded"), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(new ImageResponse(name, "Image uploaded successfully"), HttpStatus.OK);
//	}
//	
//	@GetMapping(value ="/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE )
//	public void imageDownload(@PathVariable("imageName") String imageName, HttpServletResponse httpServletResponse) throws IOException {
//		InputStream inputStream = this.imageService.getResource(path, imageName);
//		httpServletResponse.setContentType(MediaType.IMAGE_JPEG_VALUE);
//		StreamUtils.copy(inputStream, httpServletResponse.getOutputStream());
//	}
//	
//	
//}
