package com.cg.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class PhotoUpload {
	private static final String FILE_DIRECTORY = "D:\\Users\\kshelgao\\Spring Workspace\\Customer_Page\\Images";



	 public void storeFile(MultipartFile file,String filler) throws IOException {

	 Path filePath = Paths.get(FILE_DIRECTORY + "/" +filler+file.getOriginalFilename());
	 System.out.println(file.getOriginalFilename());

	 Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	 }



}
