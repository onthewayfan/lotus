package com.lotus.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 手动使用线程模拟掷骰子事件
 * @author otw
 *
 */
public class ManualDiceRolls {
	
	private static final int N = 1000000;
	
	private static final double fraction = 1.0/N ;
	private static Map<Integer, Double> reMap = new ConcurrentHashMap<>();
	private static int numberOfThreads = Runtime.getRuntime().availableProcessors(); //可用处理器的Java虚拟机的数量
	private static ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
	private static int workPerThread = N/numberOfThreads; 
	
	
	public static void main(String[] args) {
		
		System.out.println(numberOfThreads);
		
		simulateDiceRoles();
	}
	
	
	private static void simulateDiceRoles() {
		List<Future<?>> futures = submitJobs();
		awaitCompletion(futures);
	
		//executeJobs();
		
		printReMap();
		
		
		
	}
	
	private static void printReMap() {
		reMap.entrySet()
		     .forEach(System.out::println);
	}
	
	
	private static List<Future<?>> submitJobs(){
		List<Future<?>> futures = new ArrayList<Future<?>>();
		for (int i = 0; i < numberOfThreads; i++) {
			futures.add(executorService.submit(makeJob()));
		}
		return futures;
	}
	
	private static void executeJobs() {
		for (int i = 0; i < numberOfThreads; i++) {
		   executorService.execute(makeJob());	
		}
		executorService.shutdown();
	}
	
	
	private static Runnable makeJob() {
		return ()->{
			ThreadLocalRandom random = ThreadLocalRandom.current();
			for (int i = 0; i < workPerThread; i++) {
				int entry = twoDiceThrows(random);
				accumulateResult(entry);
			}
		};
	}
	
	private static int twoDiceThrows(ThreadLocalRandom random) {
		int firstThrow = random.nextInt(1,7);
		int secondThrow = random.nextInt(1, 7);
		return firstThrow+secondThrow;
	}

	private static void accumulateResult(int entry) {

		reMap.compute(entry, (k,v)->v==null?fraction:v+fraction);
	}
	
	private static void awaitCompletion(List<Future<?>> futures) {
		futures.forEach(future->{
			try {
				future.get();
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();
			}
		});
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
