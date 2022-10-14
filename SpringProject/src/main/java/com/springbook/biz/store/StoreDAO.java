package com.springbook.biz.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	// 기본 CRUD
	private final String Store_Insert = "INSERT INTO STORE(storeNum, storeId, storePw, storeName, storeCategory, storePhone, storeAddress, signUpDate) VALUES(?,?,?,?,?,?,?,?)";
	private final String Store_Update= "UPDATE STORE SET storePw=?, storeName=?, storeCategory=?, storePhone=?, storeAddress=? WHERE storeNum=?";
	private final String Store_Delete= "DELETE FROM STORE WHERE storeNum=?";
	private final String Store_Get= "SELECT * FROM STORE WHERE storeNum=?";
	private final String Store_List= "SELECT * FROM STORE ORDER BY storeNum DESC";
	
	//로그인 쿼리
	private final String Store_Login= "SELECT * FROM STORE WHERE storeId=? and storePw=?";
	
	
	public void insertStore(StoreVO vo) {
		Object[] args = { vo.getStoreNum(), vo.getStoreId(), vo.getStorePw(), vo.getStoreName(), vo.getStoreCategory(), vo.getStorePhone(), vo.getStoreAddress(), vo.getSignUpDate() };
		jdbcTemplate.update(Store_Insert, args);
	}
	
	public void updateStore(StoreVO vo) {
		Object[] args = { vo.getStorePw(), vo.getStoreName(), vo.getStoreCategory(), vo.getStorePhone(), vo.getStoreAddress(), vo.getStoreNum() };
		jdbcTemplate.update(Store_Update, args);
	}
	
	public void deleteStore(StoreVO vo) {
		Object[] args = { vo.getStoreNum() };
		jdbcTemplate.update(Store_Delete, args);
	}
	
	public StoreVO getStore(StoreVO vo) {
		try {
			Object[] args = { vo.getStoreNum() };
			return jdbcTemplate.queryForObject(Store_Get, args, new StoreRowMapper());
		}
		catch(Exception e){
			System.out.println("예외발생");
			return null;
		}
	}
	
	public List<StoreVO> getStoreList(StoreVO vo) {
		return jdbcTemplate.query(Store_List, new StoreRowMapper());
	}
	
	public StoreVO loginStore(StoreVO vo) {
		Object[] args = { vo.getStoreId(), vo.getStorePw() };
		return jdbcTemplate.queryForObject(Store_Login, args, new StoreRowMapper());
	}
}


class StoreRowMapper implements RowMapper<StoreVO> {

	public StoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StoreVO store = new StoreVO();
		store.setStoreNum(rs.getInt("storeNum"));
		store.setStoreId(rs.getString("storeId"));
		store.setStorePw(rs.getString("storePw"));
		store.setStoreName(rs.getString("storeName"));
		store.setStoreCategory(rs.getString("storeCategory"));
		store.setStorePhone(rs.getString("storePhone"));
		store.setStoreAddress(rs.getString("storeAddress"));
		store.setSignUpDate(rs.getString("signUpDate"));
		return store;
	}
	
	
}