package com.qmdj.platform.controller.upload;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.qmdj.service.common.upload.UploadUtils;

@Controller
public class UploadeFile {

	@ResponseBody
	@RequestMapping("/upload/JonsImage")
	public String uploadJsonImage(@RequestParam(value = "file",required=false) MultipartFile file){
		ReUpload<String> re= new ReUpload<String>(); 
		try {
		  String path=	UploadUtils.imageUpload(file.getName(), file.getBytes(),false);
		  re.setSuccess(true);
		  re.setDate(path);
		} catch (Exception e) {
		}
		return JSONArray.toJSONString(re);
	}
	
	
	@RequestMapping("/upload/image")
	public String uploadImage(MultipartFile file,Model model,String collBack){
		try {
		  String path=	UploadUtils.imageUpload(file.getName(), file.getBytes(),false);
		  model.addAttribute("", path);
		} catch (IOException e) {
		}
		return collBack;
	}
	
	
}
