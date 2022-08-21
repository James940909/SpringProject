package com.springbook.biz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("storeService")
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreDAO storeDAO;

	@Override
	public void insertStore(StoreVO vo) {
		storeDAO.insertStore(vo);
	}

	@Override
	public void updateStore(StoreVO vo) {
		storeDAO.updateStore(vo);
	}

	@Override
	public void deleteStore(StoreVO vo) {
		storeDAO.deleteStore(vo);
	}

	@Override
	public StoreVO getStore(StoreVO vo) {
		return storeDAO.getStore(vo);
	}

	@Override
	public List<StoreVO> getStoreList(StoreVO vo) {
		return storeDAO.getStoreList(vo);
	}

}
