package com.springbook.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.menu.MenuDAO;
import com.springbook.biz.menu.MenuVO;

@Controller
public class MenuController {
	
	@RequestMapping(value="/insertMenu.do")
	public String insertMenu(MenuVO vo, MenuDAO menuAO) {
		return null;
	}
	
	@RequestMapping(value="/updateMenu.do")
	public String updateMenu(MenuVO vo, MenuDAO menuDAO) {
		return null;
	}
	
	@RequestMapping(value="/deleteMenu.do")
	public String deleteMenu(MenuVO vo, MenuDAO menuDAO) {
		return null;
	}
	
	@RequestMapping(value="/getMenu.do")
	public ModelAndView getMenu(MenuVO vo, MenuDAO menuDAO, ModelAndView mav) {
		return null;
	}
	
	@RequestMapping(value="/getMenuList.do")
	public ModelAndView getMenuList(MenuVO vo, MenuDAO menuDAO, ModelAndView mav) {
		return null;
	}
}
