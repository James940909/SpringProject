package com.springbook.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.menu.MenuDAO;
import com.springbook.biz.menu.MenuService;
import com.springbook.biz.menu.MenuVO;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/insertMenu.do")
	public String insertMenu(MenuVO vo) {
		System.out.println("메뉴 등록 처리 시작");
		menuService.insertMenu(vo);
		return "menuPage.do";
	}
	
	@RequestMapping(value="/updateMenu.do")
	public String updateMenu(MenuVO vo, MenuDAO menuDAO) {
		System.out.println("메뉴 수정 처리 시작");
		menuDAO.updateMenu(vo);
		return "getMenu.jsp";
	}
	
	@RequestMapping(value="/deleteMenu.do")
	public String deleteMenu(MenuVO vo, MenuDAO menuDAO) {
		System.out.println("메뉴 삭제 처리 시작");
		menuDAO.deleteMenu(vo);
		return "menuPage.do";
	}
	
	@RequestMapping(value="/getMenu.do")
	public String getMenu(MenuVO vo, MenuDAO menuDAO, Model model) {
		System.out.println("메뉴 상세보기 처리 시작");
		
		model.addAttribute("menu", menuDAO.getMenu(vo));
		
		return "getMenu.jsp";
	}
	
	@RequestMapping(value="/getMenuList.do")
	public String getMenuList(MenuVO vo, MenuDAO menuDAO, Model model) {
		System.out.println("메뉴 모두 보기 처리 시작");
		
		model.addAttribute("menuList", menuDAO.getMenuList(vo));
		
		return "menuPage.do";
	}
}
