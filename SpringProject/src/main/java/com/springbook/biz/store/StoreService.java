package com.springbook.biz.store;

import java.util.List;

public interface StoreService {
	//가게등록
	void insertStore(StoreVO vo);
	//가게수정
	void updateStore(StoreVO vo);
	//가게삭제
	void deleteStore(StoreVO vo);
	//가게 상세보기
	StoreVO getStore(StoreVO vo);
	//가게 목록조회
	List<StoreVO> getStoreList(StoreVO vo);
}
