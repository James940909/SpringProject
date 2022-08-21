package com.springbook.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.review.ReviewDAO;
import com.springbook.biz.review.ReviewService;
import com.springbook.biz.review.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/insertReview.do")
	public String insertReview(ReviewVO vo) {
		System.out.println("���� �ۼ� ó�� ����");
		reviewService.insertReview(vo);
		return "reviewPage.do";
	}
	
	@RequestMapping(value="/updateReview.do")
	public String updateReview(ReviewVO vo, ReviewDAO reviewDAO) {
		System.out.println("���� ���� ó�� ����");
		reviewDAO.updateReview(vo);
		return "reviewPage.do";
	}
	
	@RequestMapping(value="/deleteReview.do")
	public String deleteReview(ReviewVO vo, ReviewDAO reviewDAO) {
		System.out.println("���� ���� ó�� ����");
		reviewDAO.deleteReview(vo);
		return "reviewPage.do";
	}
	
	@RequestMapping(value="/getReview.do")
	public String getReview(ReviewVO vo, ReviewDAO reviewDAO, Model model) {
		System.out.println("���� �󼼺��� ó�� ����");
		
		model.addAttribute("review", reviewDAO.getReview(vo));
		
		return "getReview.jsp";
	}
	
	@RequestMapping(value="/getReviewList.do")
	public String getReviewList(ReviewVO vo, ReviewDAO reviewDAO, Model model) {
		System.out.println("���� ��κ��� ó�� ����");
		
		model.addAttribute("reviewList", reviewDAO.getReviewList(vo));
		
		return "getReviewList.jsp";
	}
}
