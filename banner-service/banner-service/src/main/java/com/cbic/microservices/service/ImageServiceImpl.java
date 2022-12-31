package com.cbic.microservices.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService{

	@Override
	public String uploadImge(String path, MultipartFile multipartFile) throws IOException {
		String name = multipartFile.getOriginalFilename();
		String filePath = path+File.separator+name;
		//String filePath = path+File.separator+(UUID.randomUUID().toString()).concat(name.substring(name.lastIndexOf(".")));;

		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		Files.copy(multipartFile.getInputStream(), Paths.get(filePath));
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws IOException {
		String fulFilePath = path+File.separator+fileName;
		InputStream inputStream = new FileInputStream(fulFilePath);
		return inputStream;
	}

	@Override
	public Boolean deleteImage(String path, String fileName) throws IOException {
		String fulFilePath = path+File.separator+fileName;
		File file = new File(fulFilePath);
		if(file.delete()) {
			return true;
		}
		return false;
	}

}
