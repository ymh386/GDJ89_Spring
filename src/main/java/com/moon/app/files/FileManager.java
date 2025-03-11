package com.moon.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public void fileDelete(String path, String fileName) throws Exception{
		File file = new File(path, fileName);
		if(file.exists()) {
			boolean check = file.delete();
		}
	}
	
	public static String fileSave(String path, MultipartFile profile) throws Exception {
		
		File file = new File(path);
				
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 어떤파일을 어떤이름으로 저장??
		//	1)시간
//		Calendar ca = Calendar.getInstance();
//		long mil = ca.getTimeInMillis();
//		String f = profile.getOriginalFilename();
//		f = f.substring(f.lastIndexOf("."));
//		f = mil + f;
		
		//	2)객체 사용
		String f =UUID.randomUUID().toString();
		f = f+"_"+profile.getOriginalFilename();
		
		//3. HDD에 저장
			//1) transferTo
		file = new File(file, f);
//		profile.transferTo(file);
		
			//2) FileCopyUtils
		FileCopyUtils.copy(profile.getBytes(), file);
		
		return f;
	}

}
