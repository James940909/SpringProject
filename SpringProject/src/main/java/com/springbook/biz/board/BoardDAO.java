package com.springbook.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	// ±âº» CRUD
	private final String Board_Insert = "INSERT INTO BOARD(boardTitle, boardWriter, boardContent) VALUES(?,?,?)";
	private final String Board_Update= "UPDATE BOARD SET boardTitle=?, BoardWriter=?, boardContent=? WHERE boardNum=?";
	private final String Board_Delete= "DELETE BOARD WHERE boardNum=?";
	private final String Board_Get= "SELECT * FROM BOARD WHERE boardNum=?";
	private final String Board_List= "SELECT * FROM BOARD ORDER BY boardNum DESC";
	
	
	public void insertBoard(BoardVO vo) {
		Object[] args = { vo.getBoardTitle(), vo.getBoardWriter(), vo.getBoardContent() };
		jdbcTemplate.update(Board_Insert, args);
	}
	
	public void updateBoard(BoardVO vo) {
		Object[] args = { vo.getBoardTitle(), vo.getBoardWriter(), vo.getBoardContent(), vo.getBoardNum() };
		jdbcTemplate.update(Board_Update, args);
	}
	
	public void deleteBoard(BoardVO vo) {
		Object[] args = { vo.getBoardNum() };
		jdbcTemplate.update(Board_Delete, args);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		Object[] args = { vo.getBoardNum() };
		return jdbcTemplate.queryForObject(Board_Get, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return jdbcTemplate.query(Board_List, new BoardRowMapper());
	}
}


class BoardRowMapper implements RowMapper<BoardVO> {

	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setBoardNum(rs.getInt("boardNum"));
		board.setBoardTitle(rs.getString("boardTitle"));
		board.setBoardWriter(rs.getString("boardWriter"));
		board.setBoardContent(rs.getString("boardContent"));
		board.setBoardDate(rs.getString("boardDate"));
		board.setBoardCnt(rs.getInt("boardCnt"));
		board.setStore_Num(rs.getInt("store_Num"));
		return board;
	}
	
	
}