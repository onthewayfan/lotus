package com.lotus.base.util;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawHtmlUtil {
	
	public String crawDate(String url) throws IOException {
		String data = new String();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response  = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			if(entity!=null) {
				return EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			response.close();
		}
		return data;
	}
	
	public Document resolovDate(String html) {
		return Jsoup.parse(html);
	}

}
