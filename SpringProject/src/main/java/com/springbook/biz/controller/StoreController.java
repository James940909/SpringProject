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
	
	// ȸ������
	@RequestMapping(value="/insertStore.do")
	public String insertStore(StoreVO vo) {
		System.out.println("ȸ������ ó�� ����");
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(date);
		vo.setSignUpDate(now);
		storeService.insertStore(vo);
		return "mainPage.do";
	}
	
	// ȸ������ ����
	@RequestMapping(value="/updateStore.do", method=RequestMethod.POST)
	public String updateStore(StoreVO vo, HttpSession session) {
		System.out.println("ȸ������ ���� ó�� ����");
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		storeService.updateStore(vo);
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping(value="/updateStore.do", method=RequestMethod.GET)
	public String updateStorePage(StoreVO vo, HttpSession session, Model model) {
		System.out.println("ȸ������ ���� ������ �̵�");
		
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		model.addAttribute("store", storeService.getStore(vo));
		
		return "updateStore.jsp";
	}
	
	// ȸ��Ż��
	@RequestMapping(value="/deleteStore.do")
	public String deleteStore(StoreVO vo, HttpSession session) {
		System.out.println("ȸ��Ż�� ó�� ����");
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		storeService.deleteStore(vo);
		session.invalidate();
		return "index.jsp";
	}
	
	//�����ڰ� ȸ�� ����
	@RequestMapping(value="/deleteStoreForAdmin.do")
	public String deleteStoreForAdmin(StoreVO vo, HttpSession session) {
		System.out.println("ȸ��Ż�� ó�� ����");
		storeService.deleteStore(vo);
		return "getStoreList.do";
	}
	
	// ȸ������ �󼼺���
	@RequestMapping(value="/getStore.do")
	public String getStore(StoreVO vo, HttpSession session, Model model) {
		System.out.println("ȸ������ �󼼺��� ó�� ����");
		
		vo.setStoreNum((int)session.getAttribute("storeNum"));
		model.addAttribute("store", storeService.getStore(vo));
		
		return "getStore.jsp";
	}
	
	// ȸ������ ��κ���
	@RequestMapping(value="/getStoreList.do")
	public String getStoreList(StoreVO vo, Model model) {
		System.out.println("ȸ������ ��κ��� ó�� ����");
		
		model.addAttribute("storeList", storeService.getStoreList(vo));
		
		return "adminPage.jsp";
	}
}
