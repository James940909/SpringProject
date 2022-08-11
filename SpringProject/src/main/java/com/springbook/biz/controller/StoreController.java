package com.springbook.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.store.StoreDAO;
import com.springbook.biz.store.StoreVO;

@Controller
public class StoreController {
	
	// ȸ������
	@RequestMapping(value="/insertStore.do")
	public String insertStore(StoreVO vo, StoreDAO storeDAO) {
		System.out.println("ȸ������ ó�� ����");
		storeDAO.insertStore(vo);
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
