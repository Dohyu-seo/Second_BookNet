package com.pageturner.cls.util;

/**
 * 이 클래스는 도서 api의 종류에 따른 코드를 만들어, 원하는 주소값을 정의한 클래스입니다.
 * @author 서동혁
 * @since 25th Jun 2020
 * @version v.1.0
 *
 */

public class LibAPI {
	private final String KEY = "427a68556f3530323334526456556d"; // 서울도서관 API를 위한 KEY 값
	public final int SEARCH = 1001;
	
	public String selectUrl(int code) {
		String api = null;
		String query = null;
		String base;
		switch(code) {
		case SEARCH:
			api = "http://openapi.seoul.go.kr:8088/";
			query = "/json/SeoulPublicLibraryInfo/0/5/";
			break;
		}
		
		base = api + KEY + query;
		return base;
	}

}
