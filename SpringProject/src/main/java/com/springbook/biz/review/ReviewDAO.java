package com.springbook.biz.review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	// ±âº» CRUD
	private final String Review_Insert = "INSERT INTO REVIEW(reviewWriter, reviewScore, reviewContent, r_img) VALUES(?,?,?,?)";
	private final String Review_Update= "UPDATE REVIEW SET reviewWriter=?, reviewScore=?, reviewContent=?, r_img=? WHERE reviewNum=?";
	private final String Review_Delete= "DELETE REVIEW WHERE reviewNum=?";
	private final String Review_Get= "SELECT * FROM REVIEW WHERE reviewNum=?";
	private final String Review_List= "SELECT * FROM REVIEW ORDER BY reviewNum DESC";
	
	
	public void insertReview(ReviewVO vo) {
		Object[] args = { vo.getReviewWriter(), vo.getReviewScore(), vo.getReviewContent(), vo.getR_img() };
		jdbcTemplate.update(Review_Insert, args);
	}
	
	public void updateReview(ReviewVO vo) {
		Object[] args = { vo.getReviewWriter(), vo.getReviewScore(), vo.getReviewContent(), vo.getR_img(), vo.getReviewNum() };
		jdbcTemplate.update(Review_Update, args);
	}
	
	public void deleteReview(ReviewVO vo) {
		Object[] args = { vo.getReviewNum() };
		jdbcTemplate.update(Review_Delete, args);
	}
	
	public ReviewVO getReview(ReviewVO vo) {
		Object[] args = { vo.getReviewNum() };
		return jdbcTemplate.queryForObject(Review_Get, args, new ReviewRowMapper());
	}
	
	public List<ReviewVO> getReviewList(ReviewVO vo) {
		return jdbcTemplate.query(Review_List, new ReviewRowMapper());
	}
}


class ReviewRowMapper implements RowMapper<ReviewVO> {

	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReviewVO review = new ReviewVO();
		review.setReviewNum(rs.getInt("reviewNum"));
		review.setReviewWriter(rs.getString("reviewWriter"));
		review.setReviewScore(rs.getFloat("reviewScore"));
		review.setReviewContent(rs.getString("reviewContent"));
		review.setReviewDate(rs.getString("reviewDate"));
		review.setStore_Num(rs.getInt("store_Num"));
		review.setR_img(rs.getString("r_img"));
		return review;
	}
	
	
}