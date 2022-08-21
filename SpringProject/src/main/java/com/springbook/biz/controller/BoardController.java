package com.springbook.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDAO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("�Խñ� ��� ó�� ����");
		boardService.insertBoard(vo);
		return "boardPage.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�Խñ� ���� ó�� ����");
		boardDAO.updateBoard(vo);
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�Խñ� ���� ó�� ����");
		boardDAO.deleteBoard(vo);
		return "boardPage.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�Խñ� �󼼺��� ó�� ����");

		model.addAttribute("board", boardDAO.getBoard(vo));
		
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�Խñ� ��κ��� ó�� ����");
		
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		
		return "boardPage.do";
	}
}
