package com.wooridoori.app.crawling;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

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
		final String path = "D:\\0607KIM\\workspace\\WooriDoori\\src\\main\\webapp\\images\\crawling\\"; // 이미지 저장 경로 확인!!!
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
					String imageName=itr3.next().attr("style");
					int a=imageName.indexOf(")");
					int b=imageName.lastIndexOf(".");
					
					String imageNameS=imageName.substring(22,a);
					String imagePath = imageNameS;
					BufferedImage image = null;
					
					System.out.println("클래스 사진 : "+imageName.substring(57,b)+".jpg");	
					
					try {
						image = ImageIO.read(new URL(imagePath));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int width = image.getWidth();
					int height = image.getHeight();
					
					String fileNm = imageName.substring(57,b)+".jpg";
					
					try {
						// 저장할 이미지의 크기와 타입을 잡아줌.
						BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
						bufferedImage.createGraphics().drawImage(image, 0, 0, null);

						// 해당경로에 이미지를 저장함.
						ImageIO.write(bufferedImage, "jpg", new File(path + fileNm));
					} catch(Exception e) {
						e.printStackTrace();
					}

				}
				System.out.println("주소 : "+itr4.next().text());
				
				System.out.println("카테고리 : "+itr5.next().text());
				
			}
		}
	}
}