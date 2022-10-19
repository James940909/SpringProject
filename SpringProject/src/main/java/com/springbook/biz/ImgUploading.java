package com.springbook.biz;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.menu.MenuVO;
import com.springbook.biz.review.ReviewVO;

@Repository
public class ImgUploading {
	
	public void MenuimgUploading (MultipartFile menuImgUpload, MenuVO vo, HttpSession session) throws IllegalStateException, IOException {
		
		menuImgUpload=vo.getMenuImgUpload();
		String FilePath = "C:\\Kim_0909\\workspace_spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringProject\\img\\";
		
		if(!menuImgUpload.isEmpty()) {
			String OriginalFile = menuImgUpload.getOriginalFilename();
			String OriginalFileExtension = OriginalFile.substring(OriginalFile.lastIndexOf("."));
			String NewFileName = session.getAttribute("storeName")+"_"+session.getAttribute("storeNum")+"_"+vo.getMenuName()+OriginalFileExtension;
			File file = new File(FilePath+NewFileName);
			menuImgUpload.transferTo(file);
			vo.setM_img(FilePath+NewFileName);
			vo.setStore_Num((int)session.getAttribute("storeNum"));
		}
		else {
			vo.setM_img("C:\\Users\\dsschool\\git\\SpringProject\\SpringProject\\src\\main\\webapp\\img\\default.png");
			vo.setStore_Num((int)session.getAttribute("storeNum"));
		}
		
	}
	
	public void ReviewimgUploading (MultipartFile reviewImgUpload, ReviewVO vo, HttpSession session) throws IllegalStateException, IOException {
		
		reviewImgUpload=vo.getReviewImgUpload();
		String FilePath = "C:\\Kim_0909\\workspace_spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringProject\\img\\";
		
		if(!reviewImgUpload.isEmpty()) {
			String OriginalFile = reviewImgUpload.getOriginalFilename();
			String OriginalFileExtension = OriginalFile.substring(OriginalFile.lastIndexOf("."));
			String NewFileName = "Review_¼öÁ¤_"+session.getAttribute("storeName")+"_"+vo.getReviewNum()+OriginalFileExtension;
			File file = new File(FilePath+NewFileName);
			reviewImgUpload.transferTo(file);
			vo.setR_img(FilePath+NewFileName);
			vo.setStore_Num((int)session.getAttribute("storeNum"));
		}
		else {
			vo.setR_img("C:\\Users\\dsschool\\git\\SpringProject\\SpringProject\\src\\main\\webapp\\img\\default.png");
			vo.setStore_Num((int)session.getAttribute("storeNum"));
		}
		
	}
	
}
