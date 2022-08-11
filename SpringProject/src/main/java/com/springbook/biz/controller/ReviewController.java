package com.springbook.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.review.ReviewDAO;
import com.springbook.biz.review.ReviewVO;

@Controller
public class ReviewController {
	
	@RequestMapping(value="/insertReview.do")
	public String insertReview(ReviewVO vo, ReviewDAO reviewDAO) {
		System.out.println("리뷰 작성 처리 시작");
		reviewDAO.insertReview(vo);
		return "reviewPage.do";
	}
	
	@RequestMapping(value="/updateReview.do")
	public String updateReview(ReviewVO vo, ReviewDAO reviewDAO) {
		System.out.println("리뷰 수정 처리 시작");
		reviewDAO.updateReview(vo);
		return "reviewPage.do";
	}
	
	@RequestMapping(value="/deleteReview.do")
	public String deleteReview(ReviewVO vo, ReviewDAO reviewDAO) {
		System.out.println("리뷰 삭제 처리 시작");
		reviewDAO.deleteReview(vo);
		return "reviewPage.do";
	}
	
	@RequestMapping(value="/getReview.do")
	public String getReview(ReviewVO vo, ReviewDAO reviewDAO, Model model) {
		System.out.println("리뷰 상세보기 처리 시작");
		
		model.addAttribute("review", reviewDAO.getReview(vo));
		
		return "getReview.jsp";
	}
	
	@RequestMapping(value="/getReviewList.do")
	public String getReviewList(ReviewVO vo, ReviewDAO reviewDAO, Model model) {
		System.out.println("리뷰 모두보기 처리 시작");
		
		model.addAttribute("reviewList", reviewDAO.getReviewList(vo));
		
		return "getReviewList.jsp";
	}
}
