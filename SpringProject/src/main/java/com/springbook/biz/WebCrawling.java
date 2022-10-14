package com.springbook.biz;

import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class WebCrawling {

	public ArrayList<String> newsTitle(String url) {

		Connection conn = Jsoup.connect(url);
		ArrayList<String> answer = new ArrayList<String>();
		
		try {
			Document document = conn.get();
			Elements element = document.getElementsByClass("type06_headline");
			Elements elementTitle = element.select("img");
			
			for (Element e : elementTitle) {
				answer.add(e.attr("alt"));
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return answer;
	}

	public ArrayList<String> newsContent(String url) {

		Connection conn = Jsoup.connect(url);
		ArrayList<String> answer = new ArrayList<String>();
		
		try {
			Document document = conn.get();
			Elements element = document.getElementsByClass("type06_headline");
			Elements elementContent = element.select("span.lede");
			
			for (Element e : elementContent) {
				answer.add(e.text());
            }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return answer;
	}

	public ArrayList<String> newsImg(String url) {

		Connection conn = Jsoup.connect(url);
		ArrayList<String> answer = new ArrayList<String>();
		
		try {
			Document document = conn.get();
			Elements element = document.getElementsByClass("type06_headline");
			Elements elementImg = element.select("a").select("img");
			
			for (Element e : elementImg) {
				answer.add(e.attr("src"));
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return answer;
	}

	public ArrayList<String> newsUrl(String url) {

		Connection conn = Jsoup.connect(url);
		ArrayList<String> answer = new ArrayList<String>();
		
		try {
			Document document = conn.get();
			Elements elementUrl = document.getElementsByClass("type06_headline").select(".photo").select("a");			
			
			for (Element e : elementUrl) {
				answer.add(e.attr("href"));
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return answer;
	}
}
