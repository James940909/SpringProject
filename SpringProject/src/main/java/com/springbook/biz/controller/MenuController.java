package com.springbook.biz.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.ImgUploading;
import com.springbook.biz.menu.MenuService;
import com.springbook.biz.menu.MenuVO;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private ImgUploading imgUploading;
	
	@RequestMapping(value="/insertMenu.do")
	public String insertMenu(MenuVO vo, HttpSession session, @RequestParam(name="menuImgUpload",required=false) MultipartFile menuImgUpload) throws IllegalStateException, IOException {
		System.out.println("메뉴 등록 처리 시작");
		
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
		menuService.insertMenu(vo);
		
		return "getMenuList.do";
	}
	
	@RequestMapping(value="/updateMenu.do")
	public String updateMenu(MenuVO vo, HttpSession session, @RequestParam(name="menuImgUpload",required=false) MultipartFile menuImgUpload) throws IllegalStateException, IOException {
		System.out.println("메뉴 수정 처리 시작");
		System.out.println(vo.toString());
		imgUploading.MenuimgUploading(menuImgUpload, vo, session);
		menuService.updateMenu(vo);
		return "getMenuList.do";
	}
	
	@RequestMapping(value="/deleteMenu.do")
	public String deleteMenu(MenuVO vo, HttpSession session) {
		System.out.println("메뉴 삭제 처리 시작");
		menuService.deleteMenu(vo);
		return "getMenuList.do";
	}
	
	@RequestMapping(value="/getMenu.do")
	public String getMenu(MenuVO vo, Model model) {
		System.out.println("메뉴 상세보기 처리 시작");
		
		model.addAttribute("menu", menuService.getMenu(vo));
		
		return "getMenu.jsp";
	}
	
	@RequestMapping(value="/getMenuList.do")
	public String getMenuList(MenuVO vo, HttpSession session, Model model) {
		System.out.println("메뉴 모두 보기 처리 시작");
		
		vo.setStore_Num((int)session.getAttribute("storeNum"));		
		model.addAttribute("menuList", menuService.getMenuList(vo));
		
		return "getMenuList.jsp";
	}
}
