package com.springbook.biz.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDAO menuDAO;

	@Override
	public void insertMenu(MenuVO vo) {
		menuDAO.insertMenu(vo);
	}

	@Override
	public void updateMenu(MenuVO vo) {
		menuDAO.updateMenu(vo);
	}

	@Override
	public void deleteMenu(MenuVO vo) {
		menuDAO.deleteMenu(vo);
	}

	@Override
	public MenuVO getMenu(MenuVO vo) {
		return menuDAO.getMenu(vo);
	}

	@Override
	public List<MenuVO> getMenuList(MenuVO vo) {
		return menuDAO.getMenuList(vo);
	}

}
