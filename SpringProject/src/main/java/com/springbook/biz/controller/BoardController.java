package com.springbook.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, HttpSession session) {
		System.out.println("게시글 등록 처리 시작");
		vo.setStore_Num((int)session.getAttribute("storeNum"));
		vo.setBoardWriter((String)session.getAttribute("storeName"));
		System.out.println(vo.toString());
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, HttpSession session) {
		System.out.println("게시글 수정 처리 시작");
		vo.setBoardWriter((String)session.getAttribute("storeName"));
		vo.setStore_Num((int)session.getAttribute("storeNum"));
		System.out.println(vo.toString());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("게시글 삭제 처리 시작");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("게시글 상세보기 처리 시작");

		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, HttpSession session) {
		System.out.println("게시글 모두보기 처리 시작");
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		model.addAttribute("sessionStoreNum", (int)session.getAttribute("storeNum"));
		model.addAttribute("sessionStoreName", (String)session.getAttribute("storeName"));
		
		return "getBoardList.jsp";
	}
}
