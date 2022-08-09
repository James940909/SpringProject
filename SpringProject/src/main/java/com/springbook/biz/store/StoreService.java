package com.springbook.biz.store;

import java.util.List;

public interface StoreService {
	//���Ե��
	void insertStore(StoreVO vo);
	//���Լ���
	void updateStore(StoreVO vo);
	//���Ի���
	void deleteStore(StoreVO vo);
	//���� �󼼺���
	StoreVO getStore(StoreVO vo);
	//���� �����ȸ
	List<StoreVO> getStoreList(StoreVO vo);
}
