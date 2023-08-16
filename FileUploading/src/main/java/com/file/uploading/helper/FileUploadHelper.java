package com.file.uploading.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String uploadirectory = "C:\\Users\\Sanket Chendake\\Documents\\workspace-spring-tool-suite-4-4.18.1.RELEASE\\FileUploading\\src\\main\\resources\\static\\image";

	// to make the path dynamic
	// ClassPathResource - gives the path of resource folder
	public final String uploadirectory = new ClassPathResource("static/image").getFile().getAbsolutePath();
	
	// to handle file IoException
	public FileUploadHelper() throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;

		try {
//			//read
//		 	InputStream iS = multipartFile.getInputStream();
//		 	byte[] data = new byte[iS.available()];
//		 	iS.read(data);
//		 	
//		 	//write
//		 	FileOutputStream fos = new FileOutputStream(uploadirectory + File.separator + multipartFile.getOriginalFilename());
//		 	fos.write(data);
//		 	
//		 	fos.flush();
//		 	fos.close();

			// alternative for this code
			// (stream, path, standard option(copy type))
			Files.copy(multipartFile.getInputStream(),
					Paths.get(uploadirectory + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}