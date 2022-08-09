package com.springbook.biz.review;

import java.util.List;

public interface ReviewService {
	//������
	void insertReview(ReviewVO vo);
	//�������
	void updateReview(ReviewVO vo);
	//�������
	void deleteReview(ReviewVO vo);
	//���� �󼼺���
	ReviewVO getReview(ReviewVO vo);
	//���� �����ȸ
	List<ReviewVO> getReviewList(ReviewVO vo);
}
