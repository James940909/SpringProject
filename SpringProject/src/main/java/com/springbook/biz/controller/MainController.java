package com.springbook.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.store.StoreDAO;
import com.springbook.biz.store.StoreVO;

@Controller
public class MainController {
	
	// �α��� ȭ������ �̵�
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginPage(StoreVO vo) {
		System.out.println("�α��� ȭ�� �̵� ó�� ����");
		
		return "login.jsp";
	}
	
	// �α��� ���� ó��
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(StoreVO vo, StoreDAO storeDAO, HttpSession session) {
		System.out.println("�α��� ���� ó�� ����");
		
		if (storeDAO.getStore(vo) != null) {
			session.setAttribute("storeName", vo.getStoreName());
			return "mainPage.do";
		}

		else {
			return "login.jsp";
		}

	}
	
	// �α׾ƿ�
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "login.jsp";
	}
	
	// ����������
	@RequestMapping(value = "/mainPage.do")
	public String mainPage() {
		return "mainPage.jsp";
	}
	
	// ����������
	@RequestMapping(value = "/reviewPage.do")
	public String reviewPage() {
		return "reviewPage.jsp";
	}
	
	// �Խ���������
	@RequestMapping(value = "/boardPage.do")
	public String boardPage() {
		return "boardPage.jsp";
	}
	
	// ȸ��������
	@RequestMapping(value = "/storePage.do")
	public String storePage() {
		return "storePage.jsp";
	}
	
	// �޴�������
	@RequestMapping(value = "/menuPage.do")
	public String menuPage() {
		return "menuPage.jsp";
	}
	
}
