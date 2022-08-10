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
	
	private final String Store_Insert = "INSERT INTO STORE(storeId, storePw, storeName, storeEmail, storePhone, storeAddress) VALUES(?,?,?,?,?,?)";
	private final String Store_Update= "UPDATE STORE SET storePw=?, storeName=?, storeEmail=?, storePhone=?, storeAddress=? WHERE storeNum=?";
	private final String Store_Delete= "DELETE STORE WHERE storeNum=?";
	private final String Store_Get= "SELECT * FROM STORE WHERE storeNum=?";
	private final String Store_List= "SELECT * FROM STORE ORDER BY storeNum DESC";
	
	
	public void insertStore(StoreVO vo) {
		Object[] args = { vo.getStoreId(), vo.getStorePw(), vo.getStoreName(), vo.getStoreEmail(), vo.getStorePhone(), vo.getStoreAddress() };
		jdbcTemplate.update(Store_Insert, args);
	}
	
	public void updateStore(StoreVO vo) {
		Object[] args = { vo.getStorePw(), vo.getStoreName(), vo.getStoreEmail(), vo.getStorePhone(), vo.getStoreAddress(), vo.getStoreNum() };
		jdbcTemplate.update(Store_Update, args);
	}
	
	public void deleteStore(StoreVO vo) {
		Object[] args = { vo.getStoreNum() };
		jdbcTemplate.update(Store_Delete, args);
	}
	
	public StoreVO getStore(StoreVO vo) {
		Object[] args = { vo.getStoreNum() };
		return jdbcTemplate.queryForObject(Store_Get, args, new StoreRowMapper());
	}
	
	public List<StoreVO> getStoreList(StoreVO vo) {
		return jdbcTemplate.query(Store_List, new StoreRowMapper());
	}
}


class StoreRowMapper implements RowMapper<StoreVO> {

	public StoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StoreVO store = new StoreVO();
		store.setStoreNum(rs.getInt("storeNum"));
		store.setStoreId(rs.getString("storeId"));
		store.setStorePw(rs.getString("storePw"));
		store.setStoreName(rs.getString("storeName"));
		store.setStoreEmail(rs.getString("storeEmail"));
		store.setStorePhone(rs.getString("storePhone"));
		store.setStoreAddress(rs.getString("storeAddress"));
		store.setSignUpDate(rs.getDate("signUpDate"));
		return store;
	}
	
	
}