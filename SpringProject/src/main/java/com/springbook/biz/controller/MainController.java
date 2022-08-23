package com.springbook.biz.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.store.StoreService;
import com.springbook.biz.store.StoreServiceImpl;
import com.springbook.biz.store.StoreVO;

@Controller
public class MainController {
	
	@Autowired
	StoreService storeService;
	@Autowired
	StoreServiceImpl storeServiceImpl;
	
	// �α��� ȭ������ �̵�
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginPage(StoreVO vo) {
		System.out.println("�α��� ȭ�� �̵� ó�� ����");
		
		return "login.jsp";
	}
	
	// �α��� ���� ó��
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(StoreVO vo, HttpSession session) {
		System.out.println("�α��� ���� ó�� ����");
		
		StoreVO store = storeServiceImpl.loginStore(vo);
		
		if ( store != null) {
			System.out.println("�α��� ����");
			System.out.println(store.toString());
			session.setAttribute("storeName", store.getStoreName());
			return "mainPage.do";
		}

		else {
			System.out.println("�α��� ����");
			return "login.jsp";
		}

	}
	
	// �α׾ƿ�
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "mainPage.do";
	}
	
	// ����������
	@RequestMapping(value = "/mainPage.do")
	public String mainPage(StoreVO vo, HttpSession session) {
		
		//session�� ��� �ڵ�
		Enumeration se = session.getAttributeNames();
		while (se.hasMoreElements()) {
			String getse = se.nextElement() + "";
			System.err.println("@@@@@@@ session : " + getse + " : " + session.getAttribute(getse));
		}
		
		return "index.jsp";
	}
	
	
	
}
