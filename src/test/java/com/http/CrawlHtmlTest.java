package com.http;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.lotus.utils.CrawHtmlUtil;

public class CrawlHtmlTest {
	public static void main(String[] args){
		CrawHtmlUtil crawHtml = new CrawHtmlUtil();
		String url = "http://news.baidu.com/";
		String resultHtml = "";
		try {
			resultHtml = crawHtml.crawDate(url);
			System.out.println(resultHtml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Document doc1 =Jsoup.parse(resultHtml);
		Document doc2 =null;
		try {
			doc2 =Jsoup.connect(url)
					          .data("query","java")
					          .cookie("auth", "token")
			                  .timeout(3000)
			                  .post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(doc2.title());
		
		
		
	}

}
