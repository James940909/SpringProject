package com.springbook.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.store.StoreDAO;
import com.springbook.biz.store.StoreVO;

@Controller
public class MainController {
	
	// 로그인 화면으로 이동
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginPage(StoreVO vo) {
		System.out.println("로그인 화면 이동 처리 시작");
		
		return "login.jsp";
	}
	
	// 로그인 인증 처리
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(StoreVO vo, StoreDAO storeDAO, HttpSession session) {
		System.out.println("로그인 인증 처리 시작");
		
		if (storeDAO.getStore(vo) != null) {
			session.setAttribute("storeName", vo.getStoreName());
			return "mainPage.do";
		}

		else {
			return "login.jsp";
		}

	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "login.jsp";
	}
	
	// 메인페이지
	@RequestMapping(value = "/mainPage.do")
	public String mainPage() {
		return "mainPage.jsp";
	}
	
	// 리뷰페이지
	@RequestMapping(value = "/reviewPage.do")
	public String reviewPage() {
		return "reviewPage.jsp";
	}
	
	// 게시판페이지
	@RequestMapping(value = "/boardPage.do")
	public String boardPage() {
		return "boardPage.jsp";
	}
	
	// 회원페이지
	@RequestMapping(value = "/storePage.do")
	public String storePage() {
		return "storePage.jsp";
	}
	
	// 메뉴페이지
	@RequestMapping(value = "/menuPage.do")
	public String menuPage() {
		return "menuPage.jsp";
	}
	
}
