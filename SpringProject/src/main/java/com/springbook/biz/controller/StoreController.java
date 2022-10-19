package com.springbook.biz.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		storeService.insertStore(vo);
		return "mainPage.do";
	}
	
	// 회원정보 수정
	@RequestMapping(value="/updateStore.do", method=RequestMethod.POST)
	public String updateStore(StoreVO vo, HttpSession session) {
		System.out.println("회원정보 수정 처리 시작");
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		storeService.updateStore(vo);
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping(value="/updateStore.do", method=RequestMethod.GET)
	public String updateStorePage(StoreVO vo, HttpSession session, Model model) {
		System.out.println("회원정보 수정 페이지 이동");
		
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		model.addAttribute("store", storeService.getStore(vo));
		
		return "updateStore.jsp";
	}
	
	// 회원탈퇴
	@RequestMapping(value="/deleteStore.do")
	public String deleteStore(StoreVO vo, HttpSession session) {
		System.out.println("회원탈퇴 처리 시작");
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		storeService.deleteStore(vo);
		session.invalidate();
		return "index.jsp";
	}
	
	//관리자가 회원 삭제
	@RequestMapping(value="/deleteStoreForAdmin.do")
	public String deleteStoreForAdmin(StoreVO vo, HttpSession session) {
		System.out.println("회원탈퇴 처리 시작");
		storeService.deleteStore(vo);
		return "getStoreList.do";
	}
	
	// 회원정보 상세보기
	@RequestMapping(value="/getStore.do")
	public String getStore(StoreVO vo, HttpSession session, Model model) {
		System.out.println("회원정보 상세보기 처리 시작");
		
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		model.addAttribute("store", storeService.getStore(vo));
		
		return "getStore.jsp";
	}
	
	// 회원정보 모두보기
	@RequestMapping(value="/getStoreList.do")
	public String getStoreList(StoreVO vo, Model model) {
		System.out.println("회원정보 모두보기 처리 시작");
		
		model.addAttribute("storeList", storeService.getStoreList(vo));
		
		return "adminPage.jsp";
	}
}
