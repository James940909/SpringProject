package com.springbook.biz.menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	// ±âº» CRUD
	private final String Menu_Insert = "INSERT INTO MENU(menuName, menuPrice, store_Num, m_img) VALUES(?,?,?,?)";
	private final String Menu_Update= "UPDATE MENU SET menuName=?, menuPrice=?, m_img=? WHERE menuNum=?";
	private final String Menu_Delete= "DELETE FROM MENU WHERE menuNum=?";
	private final String Menu_Get= "SELECT * FROM MENU WHERE menuNum=?";
	private final String Menu_List= "SELECT * FROM MENU WHERE store_Num=?";
	
	
	public void insertMenu(MenuVO vo) {
		Object[] args = { vo.getMenuName(), vo.getMenuPrice(), vo.getStore_Num(), vo.getM_img() };
		jdbcTemplate.update(Menu_Insert, args);
	}
	
	public void updateMenu(MenuVO vo) {
		Object[] args = { vo.getMenuName(), vo.getMenuPrice(), vo.getM_img(), vo.getMenuNum() };
		jdbcTemplate.update(Menu_Update, args);
	}
	
	public void deleteMenu(MenuVO vo) {
		Object[] args = { vo.getMenuNum() };
		jdbcTemplate.update(Menu_Delete, args);
	}
	
	public MenuVO getMenu(MenuVO vo) {
		Object[] args = { vo.getMenuNum() };
		return jdbcTemplate.queryForObject(Menu_Get, args, new MenuRowMapper());
	}
	
	public List<MenuVO> getMenuList(MenuVO vo) {
		Object[] args = { vo.getStore_Num() };
		return jdbcTemplate.query(Menu_List, args, new MenuRowMapper());
	}
}


class MenuRowMapper implements RowMapper<MenuVO> {

	public MenuVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuVO menu = new MenuVO();
		menu.setMenuNum(rs.getInt("menuNum"));
		menu.setMenuName(rs.getString("menuName"));
		menu.setMenuPrice(rs.getInt("menuPrice"));
		menu.setStore_Num(rs.getInt("store_Num"));
		menu.setM_img(rs.getString("m_img"));
		return menu;
	}
	
	
}