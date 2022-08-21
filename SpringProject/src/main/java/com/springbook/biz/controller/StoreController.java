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
	
	// ȸ������
	@RequestMapping(value="/insertStore.do")
	public String insertStore(StoreVO vo) {
		System.out.println("ȸ������ ó�� ����");
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(date);
		
		vo.setSignUpDate(now);
		
		System.out.println(vo.toString());
		storeService.insertStore(vo);
		System.out.println("test�α�");
		return "mainPage.do";
	}
	
	// ȸ������ ����
	@RequestMapping(value="/updateStore.do")
	public String updateStore(StoreVO vo, StoreDAO storeDAO) {
		System.out.println("ȸ������ ���� ó�� ����");
		storeDAO.updateStore(vo);
		return "mainPage.do";
	}
	
	// ȸ��Ż��
	@RequestMapping(value="/deleteStore.do")
	public String deleteStore(StoreVO vo, StoreDAO storeDAO) {
		System.out.println("ȸ��Ż�� ó�� ����");
		storeDAO.deleteStore(vo);
		return "mainPage.do";
	}
	
	// ȸ������ �󼼺���
	@RequestMapping(value="/getStore.do")
	public String getStore(StoreVO vo, StoreDAO storeDAO, Model model) {
		System.out.println("ȸ������ �󼼺��� ó�� ����");
		
		model.addAttribute("store", storeDAO.getStore(vo));
		
		return "getStore.jsp";
	}
	
	// ȸ������ ��κ���
	@RequestMapping(value="/getStoreList.do")
	public String getStoreList(StoreVO vo, StoreDAO storeDAO, Model model) {
		System.out.println("ȸ������ ��κ��� ó�� ����");
		
		model.addAttribute("storeList", storeDAO.getStoreList(vo));
		
		return "getStoreList.jsp";
	}
}
