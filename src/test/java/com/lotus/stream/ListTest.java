package com.lotus.stream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {
	
	
	public static void main(String[] args) {
		
		List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			Map<String, Object> m = new HashMap<>();
			//m.put("name", "name"+(5-i));
			m.put("name", (5-i));
			lm.add(m);
		}
		m1.put("name", null);
		lm.add(m1);
		System.out.println(lm);
		
/*		lm.forEach(v->{
			v.get("name");
		});*/
		
		lm.sort((o1,o2)->String.valueOf(o1.get("name")).compareTo(String.valueOf(o2.get("name"))));
		System.out.println(lm);
		lm.sort((o1,o2)->String.valueOf(o2.get("name")).compareTo(String.valueOf(o1.get("name"))));
		System.out.println(lm);
		
		lm.sort((o1,o2)->{
			if(String.valueOf(o2.get("age")).equals(String.valueOf(o1.get("age")))) {
				return String.valueOf(o2.get("name")).compareTo(String.valueOf(o1.get("name")));
			}else {
				return String.valueOf(o2.get("name")).compareTo(String.valueOf(o1.get("name")));
			}
		});
		
		
		
		
	}

}
