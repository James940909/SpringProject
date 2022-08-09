package com.springbook.biz.review;

import java.util.List;

public interface ReviewService {
	//리뷰등록
	void insertReview(ReviewVO vo);
	//리뷰수정
	void updateReview(ReviewVO vo);
	//리뷰삭제
	void deleteReview(ReviewVO vo);
	//리뷰 상세보기
	ReviewVO getReview(ReviewVO vo);
	//리뷰 목록조회
	List<ReviewVO> getReviewList(ReviewVO vo);
}
