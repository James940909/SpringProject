package com.springbook.biz.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.store.StoreDAO;
import com.springbook.biz.store.StoreService;
import com.springbook.biz.store.StoreVO;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	// 회원가입
	@RequestMapping(value="/insertStore.do")
	public String insertStore(StoreVO vo) {
		System.out.println("회원가입 처리 시작");
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(date);
		
		vo.setSignUpDate(now);
		
		System.out.println(vo.toString());
		storeService.insertStore(vo);
		System.out.println("test로깅");
		return "mainPage.do";
	}
	
	// 회원정보 수정
	@RequestMapping(value="/updateStore.do")
	public String updateStore(StoreVO vo, StoreDAO storeDAO) {
		System.out.println("회원정보 수정 처리 시작");
		storeDAO.updateStore(vo);
		return "mainPage.do";
	}
	
	// 회원탈퇴
	@RequestMapping(value="/deleteStore.do")
	public String deleteStore(StoreVO vo, StoreDAO storeDAO) {
		System.out.println("회원탈퇴 처리 시작");
		storeDAO.deleteStore(vo);
		return "mainPage.do";
	}
	
	// 회원정보 상세보기
	@RequestMapping(value="/getStore.do")
	public String getStore(StoreVO vo, StoreDAO storeDAO, Model model) {
		System.out.println("회원정보 상세보기 처리 시작");
		
		model.addAttribute("store", storeDAO.getStore(vo));
		
		return "getStore.jsp";
	}
	
	// 회원정보 모두보기
	@RequestMapping(value="/getStoreList.do")
	public String getStoreList(StoreVO vo, StoreDAO storeDAO, Model model) {
		System.out.println("회원정보 모두보기 처리 시작");
		
		model.addAttribute("storeList", storeDAO.getStoreList(vo));
		
		return "getStoreList.jsp";
	}
}
