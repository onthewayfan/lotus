package com.lotus.dao.dbtest;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Stratup;
import com.lotus.test.dao.HotNewsDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Stratup.class)
public class HotNewsDaoTest {
	
	@Autowired
	private HotNewsDao hotNewsDao;
	
	@Test
	public void query() {
	
		List<Map<String, Object>>  result = null;
		try {
			result =  hotNewsDao.query();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
	}
	
	
	

}
