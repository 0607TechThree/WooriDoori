package com.wooridoori.app.crawling;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	// 101 서울
	// 102 경기 
	// 103 인천 47개
	// 112 부산 32개
	// 107 충남 12개
	// 108 대전 11개
	// 111 울산 5개
	// 110 대구 3개
	// 109 경북 1개
	// 117 제주 1개
	public static void main(String[] args) {
		final String url="https://www.idus.com"; // 상세
		final String url2="https://www.idus.com/c/region/"; // 지역별
		Document doc=null;
		Document doc2=null;
		ArrayList<String> urls = new ArrayList<String>();
		urls.add(url2+101); // 서울
		urls.add(url2+102); // 경기
		urls.add(url2+103); // 인천
		urls.add(url2+112); // 부산
		urls.add(url2+107); // 충남
		urls.add(url2+108); // 대전
		urls.add(url2+111); // 울산
		urls.add(url2+110); // 대구
		urls.add(url2+109); // 경북
		urls.add(url2+117); // 제주
		
		for(int i=0;i<urls.size();i++) {
			try {
				doc=Jsoup.connect(urls.get(i)).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(doc);

			Elements e1=doc.select(".ui_card__info > a");
			Iterator<Element> itr1 = e1.iterator();
			while(itr1.hasNext()) {
				System.out.println("클래스 상세보기 주소 : "+itr1.next().attr("href"));
				try {
					doc2=Jsoup.connect(url+itr1.next().attr("href")).get();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				////상세
				Elements e2=doc2.select(".sticky_aside__title");
				Elements e3=doc2.select(".img-list.indicator > li");
				Elements e4=doc2.select(".map__labelbox > strong");
				Elements e5=doc2.select(".listwrap > ul > li > a");
				Iterator<Element> itr2 = e2.iterator();
				Iterator<Element> itr3 = e3.iterator();
				Iterator<Element> itr4 = e4.iterator();
				Iterator<Element> itr5 = e5.iterator();

				System.out.println("클래스 이름 : "+itr2.next().text());
				while(itr3.hasNext()) {
					System.out.println("클래스 사진 : "+itr3.next().attr("style"));			
				}
				System.out.println("주소 : "+itr4.next().text());
				while(itr5.hasNext()) {
					System.out.println("카테고리 : "+itr5.next().text());
				}
			}
		}
	}
}