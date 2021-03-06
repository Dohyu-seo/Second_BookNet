package com.pageturner.cls.service;

/**
 * 이 클래스는 도서검색, 베스트셀러, 추천도서 등 controller로부터 들어온 로직을 처리할 서비스클래스입니다.
 * @author leeseulkim
 * @since 25th Jun 2020
 *
 */
import java.net.URLEncoder;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.google.gson.*;
import com.pageturner.cls.util.*;
import com.pageturner.cls.vo.*;
import com.pageturner.cls.dao.*;

@Service
public class LibraryService implements LibraryAPI {

	@Override
	public String LibraryAPI(String keyword) {
		return null;
	}
//	@Autowired
//	LibAPI lApi;
//	
//	@Autowired
//	WebConnection webConn;
//	
//	@Autowired
//	ParsingLibraryInfo parsing;
//
//	String address = null;
//	String json = null;
//	ArrayList<LibraryVO> list;
//	
//	//게시글 작성시 도서검색 요청이 들어온 경우 
//	@Override
//	public String LibraryAPI(String keyword) {
//		String base = lApi.selectUrl(lApi.SEARCH);
//		
//		try {
//			//api에서부터 가져온 도서정보를 gson으로 받기 
//			String str = URLEncoder.encode(keyword, "UTF-8");
//			address = base + "&lbrry_name="+ str;
//
//			json = webConn.webConnection(address);
//			
//			//웹에서 받아온 도서정보를 파싱시켜줄 클래스 호출
//			this.list = parsing.parsingLibraryInfo(json);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		//검색된 결과를 db에 저장시켜줄 처리전담 dao 호출 
//		
//		return json;
//	}
//	
//	//베스트셀러 
//	public ArrayList<BookVO> interparkAPI(int categoryId) {
//		String base = selApi.selectUrl(selApi.BESTSELL);//이때 base는 categoryId= 로 마무리 되어 있음.
//		
//		try {
//			address = base + categoryId + "&output=json&maxResults=5";
//			
//			json = webConn.webConnection(address);
//			
//			this.list = parsing.parsingBookInfo(json);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
}
