package com.springbook.biz.controller;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.WebCrawling;
import com.springbook.biz.store.StoreService;
import com.springbook.biz.store.StoreServiceImpl;
import com.springbook.biz.store.StoreVO;

@Controller
public class MainController {
	
	@Autowired
	StoreService storeService;
	@Autowired
	StoreServiceImpl storeServiceImpl;
	@Autowired
	WebCrawling webCrawling;
	
	// 로그인 화면으로 이동
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginPage(StoreVO vo) {
		System.out.println("로그인 화면 이동 처리 시작");
		
		return "login.jsp";
	}
	
	// 로그인 인증 처리
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(StoreVO vo, HttpSession session) {
		System.out.println("로그인 인증 처리 시작");
		
		StoreVO store = storeServiceImpl.loginStore(vo);
		
		if ( store != null) {
			System.out.println("로그인 성공");
			session.setAttribute("store", store);
			session.setAttribute("storeName", store.getStoreName());
			session.setAttribute("storeNum", store.getStoreNum());
			return "mainPage.do";
		}

		else {
			System.out.println("로그인 실패");
			return "login.jsp";
		}

	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "mainPage.do";
	}
	
	// 메인페이지
	@RequestMapping(value = "/mainPage.do")
	public String mainPage(StoreVO vo, HttpSession session) {
		
		//session값 출력 코드
		Enumeration se = session.getAttributeNames();
		while (se.hasMoreElements()) {
			String getse = se.nextElement() + "";
			System.err.println("@@@@@@@ session : " + getse + " : " + session.getAttribute(getse));
		}
		
		return "index.jsp";
	}
	
	// 뉴스페이지
	@RequestMapping(value = "/newsPage.do")
	public String newsPage(Model model) {
		
		String naverNewUrl = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=103&sid2=238";
		
		ArrayList<String> title = webCrawling.newsTitle(naverNewUrl);
		ArrayList<String> content = webCrawling.newsContent(naverNewUrl);
		ArrayList<String> img = webCrawling.newsImg(naverNewUrl);
		ArrayList<String> url = webCrawling.newsUrl(naverNewUrl);
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("img", img);
		model.addAttribute("url", url);
		
		return "naverNews.jsp";
	}
	
	
}
