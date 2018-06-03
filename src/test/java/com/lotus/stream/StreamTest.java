package com.lotus.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		List<String>  all= new ArrayList<String>();
		all.add("java");
		all.add("c");
		all.add("jsp");
		all.add("javascript");
		all.add("python");
		Stream<String> stream = all.stream();
		List<String> list=stream.filter((e)->e.contains("java")).collect(Collectors.toList());
		System.out.println(list);
		Stream<String> stream1 = all.stream();
		List<String> list1=stream1.skip(5).limit(3).collect(Collectors.toList());
		System.out.println(list1);

	}

}
