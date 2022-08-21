package com.springbook.biz;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.store.StoreDAO;
import com.springbook.biz.store.StoreVO;

public class StoreServiceClient {

	public static void main(String[] args) {
		
		//1. Spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup�Ѵ�.
		StoreDAO storeDAO = (StoreDAO) container.getBean("storeDAO");
		
		
		
		StoreVO vo = new StoreVO();
		vo.setStoreNum(0);
		vo.setStoreId("11");
		vo.setStorePw("11");
		vo.setStoreName("11");
		vo.setStoreEmail("11");
		vo.setStorePhone("11");
		vo.setStoreAddress("11");
		vo.setSignUpDate("11");
		
		storeDAO.insertStore(vo);
		
		//5. Spring �����̳� ����
		container.close();
		System.out.println("�Ϸ�!");
	}

}
