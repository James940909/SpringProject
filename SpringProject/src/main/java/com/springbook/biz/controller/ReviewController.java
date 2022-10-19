package com.springbook.biz.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.ImgUploading;
import com.springbook.biz.menu.MenuService;
import com.springbook.biz.menu.MenuVO;
import com.springbook.biz.review.ReviewService;
import com.springbook.biz.review.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private ImgUploading imgUploading;
	
	@RequestMapping(value="/insertReview.do", method=RequestMethod.GET)
	public String insertReviewPage(ReviewVO vo, MenuVO mvo, HttpSession session, Model model) {
		
		mvo.setStore_Num((int)session.getAttribute("storeNum"));
		model.addAttribute("menuList", menuService.getMenuList(mvo));
		
		return "insertReview.jsp";
	}
	
	@RequestMapping(value="/insertReview.do", method=RequestMethod.POST)
	public String insertReview(ReviewVO vo, HttpSession session, @RequestParam(name="reviewImgUpload",required=false) MultipartFile reviewImgUpload) throws IllegalStateException, IOException {
		System.out.println("리뷰 작성 처리 시작");
		
		reviewImgUpload=vo.getReviewImgUpload();
		String FilePath = "C:\\Kim_0909\\workspace_spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringProject\\img\\";
		
		if(!reviewImgUpload.isEmpty()) {
			String OriginalFile = reviewImgUpload.getOriginalFilename();
			String OriginalFileExtension = OriginalFile.substring(OriginalFile.lastIndexOf("."));
			String NewFileName = "Review_"+session.getAttribute("storeName")+"_"+vo.getReviewContent().substring(0, 3)+OriginalFileExtension;
			File file = new File(FilePath+NewFileName);
			reviewImgUpload.transferTo(file);
			vo.setR_img(FilePath+NewFileName);
			vo.setStore_Num((int)session.getAttribute("storeNum"));
		}
		else {
			vo.setR_img("C:\\Users\\dsschool\\git\\SpringProject\\SpringProject\\src\\main\\webapp\\img\\default.png");
			vo.setStore_Num((int)session.getAttribute("storeNum"));
		}
		
		reviewService.insertReview(vo);
		return "getReviewList.do";
	}
	
	@RequestMapping(value="/updateReview.do", method=RequestMethod.GET)
	public String updateReviewPage(ReviewVO vo, MenuVO mvo, HttpSession session, Model model) {
		System.out.println("리뷰 수정을 위해 페이지 이동");
		mvo.setStore_Num((int)session.getAttribute("storeNum"));
		model.addAttribute("review", reviewService.getReview(vo));
		model.addAttribute("menuList", menuService.getMenuList(mvo));
		return "updateReview.jsp";
	}
	
	@RequestMapping(value="/updateReview.do", method=RequestMethod.POST)
	public String updateReview(ReviewVO vo, HttpSession session, @RequestParam(name="reviewImgUpload",required=false) MultipartFile reviewImgUpload) throws IllegalStateException, IOException {
		System.out.println("리뷰 수정 처리 시작");
		imgUploading.ReviewimgUploading(reviewImgUpload, vo, session);
		reviewService.updateReview(vo);
		return "getReviewList.do";
	}
	
	@RequestMapping(value="/deleteReview.do")
	public String deleteReview(ReviewVO vo) {
		System.out.println("리뷰 삭제 처리 시작");
		reviewService.deleteReview(vo);
		return "getReviewList.do";
	}
	
	@RequestMapping(value="/getReview.do")
	public String getReview(ReviewVO vo, Model model) {
		System.out.println("리뷰 상세보기 처리 시작");
		
		model.addAttribute("review", reviewService.getReview(vo));
		
		return "getReview.jsp";
	}
	
	@RequestMapping(value="/getReviewList.do")
	public String getReviewList(ReviewVO vo, HttpSession session, Model model) {
		System.out.println("리뷰 모두보기 처리 시작");
		
		vo.setStore_Num((int)session.getAttribute("storeNum"));
		model.addAttribute("reviewList", reviewService.getReviewList(vo));
		
		return "getReviewList.jsp";
	}
}
