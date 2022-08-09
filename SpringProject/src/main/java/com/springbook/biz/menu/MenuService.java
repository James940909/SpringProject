package com.springbook.biz.menu;

import java.util.List;

public interface MenuService {
	//메뉴등록
	void insertMenu(MenuVO vo);
	//메뉴수정
	void updateMenu(MenuVO vo);
	//메뉴삭제
	void deleteMenu(MenuVO vo);
	//메뉴 상세보기
	MenuVO getMenu(MenuVO vo);
	//메뉴 목록조회
	List<MenuVO> getMenuList(MenuVO vo);
}
