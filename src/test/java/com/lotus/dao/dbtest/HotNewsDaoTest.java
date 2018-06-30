package com.lotus.dao.dbtest;

import com.lotus.AppStratup;
import com.lotus.test.dao.HotNewsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppStratup.class)
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
