package com.springbook.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		return null;
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		return null;
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		return null;
	}
	
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		return null;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		return null;
	}
}
