package com.lotus.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import com.lotus.sys.dto.UserDto;


public class LambdaTest {
	
	
	public static void main(String[] args) {
		
		//baseLambdaMethod();
		
		//streamMethod();
		
		arraysMethodTest();
		
		
		
		
	}
	

	/**
	 *MovingAverage 是滑动平均或移动平均，是做时间序列预测时用到的简单方法
	 * 计算方法：对于一个给定的数列，首先设定一个固定的值k，然后分别计算第1项到第k项，第2项到第k+1项，第3项到第k+2项的平均值，依次类推
	 * @param values
	 * @param n
	 * @return
	 */
	public static double[] simpleMovingAverage(double[] values,int n) {
		double[] sums = Arrays.copyOf(values, values.length);
		Arrays.parallelPrefix(sums, Double::sum);
		System.out.println(Arrays.toString(sums));
		int start = n-1;
		return IntStream.range(start, sums.length)
				        .mapToDouble(i->{
				        	double prrfix = (i == start ? 0:sums[i-n]);
		                    return (sums[i] - prrfix) /n;
				        }).toArray();
	}
	
	
	
	
	
	public static void arraysMethodTest() {
		
		int[] array = new int[]{1,9,3,5,6,7,8,4,2};
		
		//任意给定一个函数，计算数组的和
		int[] sum = Arrays.copyOf(array, array.length);
		Arrays.parallelPrefix(sum,Integer::sum);

		System.out.println(Arrays.toString(sum));
				
		//使用Lambada表达式更新数组元素
		double[] values = new double[9];
		Arrays.parallelSetAll(values,i->i);
		System.out.println(Arrays.toString(values));
		
		//并行化对数组排序		
		Arrays.parallelSort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println("array的滑动平均数：");
		for (int j = 1; j < 10; j++) {
			System.out.println(Arrays.toString(simpleMovingAverage(values, j)));
		}
		
		
	}
	

	public static void streamMethod() {
		
		//统计小写字母出现次数
		String str  = "s5d4s5dawea4aAS5S545dasdasdasd4wqec1a5s4da5sd5d4q5w45das21d";
		
		long low = str.chars()
			      .filter(Character::isLowerCase)
			      .count();
		
		System.out.println(low);
		
		
		//统计相同元素出现次数
		Stream<String> names = Stream.of("John", "Paul", "George", "John",
				"Paul", "John");
	
		
		Map<String, Long> map = names.collect(Collectors.groupingBy(name->name,Collectors.counting()));
		System.out.println(map);
		
		List<String> nameList =  Arrays.asList(new String[]{"John", "Paul", "George", "John",
				"Paul", "John"});
		
		for (String string :nameList) {
			if(map.get(string)==null) {
				map.put(string, 1L);
			}else {
				map.put(string, map.get(string)+1L);
			}
		}
		System.out.println(map);
		
		//获取用户名称长度最小的用户
		Stream<UserDto> userDtos = null;
		
		Function<UserDto, Integer> getCount = user ->  user.getName().length();
		
		//Optional<UserDto> UserDto = userDtos.collect(Collectors.minBy(Comparator.comparing(getCount)));
		
		
		List<UserDto> users = new ArrayList<>();
		
		users.stream().filter(user->user.getName().equals("who are you")).count();
		
		System.out.println(Stream.of(1,2,3).map(i->i*i).collect(Collectors.toList()));
		
		
		System.out.println(Stream.of(1,2,3).reduce(0,(acc, element)->acc+element));
		
	}
	

	public static void baseLambdaMethod() {
		
		System.out.println(atLeast5.test(6));
		
		System.out.println(add.apply(7L, 8L));
		
		Function<Long, Long> squared = e -> e * e;
		
		System.out.println(add.andThen(squared).apply(7L, 8L));
		
		out.accept("Hi!");

		System.out.println(su.get());
		
		System.out.println(ssu.get().getName());
		
		System.out.println(ssu2.get());
		
		System.out.println(u.apply(9));
		
	}
	
    //Predicate bool
	static Predicate<Integer> atLeast5 = x -> x>5;
	

    //BinaryOperator 
	static BinaryOperator<Long> add = (x,y) -> x+y;
	
	
	//Consumer void 
	static Consumer<String> out = str -> System.out.println(str);
	
	
	static Supplier<String> su = () -> "Hi!";
	
	static Supplier<UserDto> ssu = () -> new UserDto().setName("who are you");
	
	static Supplier<UserDto> ssu2 = UserDto::new;
	
	
	static UnaryOperator<Integer> u = i -> i;
	
		

}
