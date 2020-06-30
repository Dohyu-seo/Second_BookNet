package com.pageturner.cls.util;
/**
 * 이 클래스는 인터파크에서 도서정보를 받아와 json으로 파싱, 리스트로 반환해주는 클래스이다.
 * @author 서동혁
 * @since 2020.06.30
 * @see
 * 		BookNet/InterParkAPI from 박기윤 
 *
 */

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import com.pageturner.cls.vo.LibraryVO;

public class LibraryAPI {
	private final String KEY = "427a68556f3530323334526456556d"; //도서관 API를 위한 KEY 값

	public JSONArray item;
	public JSONObject obj;
	
	//요청 변수 (api는 주소, query는 쿼리 혹은 카테고리아이디)
	String api ;// "http://openapi.seoul.go.kr:8088/(인증키)/json/SeoulPublicLibraryInfo/1/5/";
	
	String str = null;
	String json = null;
	String address = null;
	private ArrayList<LibraryVO> list;
	
	//도서 장르별로 검색할 수 있게 하기 
	public LibraryAPI(String LBRRY_NAME) {
		//책검색 API 생성자 함수를 만들어서 처리
		String base = api + "?KEY=" + KEY + "&TYPE=json&SERVICE=SeoulPublicLibraryInfo&START_INDEX=1&END_INDEX=2";
		
		System.out.println("완료1");
		try {
			str = URLEncoder.encode(LBRRY_NAME, "UTF-8");
			System.out.println("완료2");
			address = base + "LBRRY_NAME=" + str;
			
			json = webConnection(address);
			this.list = parsingLibraryInfo(json);
			
			System.out.println(list.size());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//api를 제공해주는 웹에 연결하여 원하는 결과값을 json 타입으로 받기
	public String webConnection(String address) throws Exception {
		System.out.println("완료3");
		String json = null;
		BufferedReader br;
		URL url;
		HttpURLConnection conn;
		String protocol = "POST";
		
		System.out.println("완료3-1");
		url = new URL(address);
		System.out.println("완료3-url" + url);
		conn = (HttpURLConnection)url.openConnection();
		System.out.println("완료3-conn" + conn);
		conn.setRequestMethod(protocol);
		System.out.println("완료3-conn2" + protocol);
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		System.out.println("완료3-br" + br);
		
		json = br.readLine();
		
		System.out.println("완료3-2");
		return json;
	}
	
	//json object에서 item(결과물들)의 정보들을 담는다.
	public ArrayList<LibraryVO> parsingLibraryInfo(String json) throws Exception {
		System.out.println("완료4");
		ArrayList<LibraryVO> list = new ArrayList<LibraryVO>();
		
		JSONParser parser = new JSONParser();
		obj = (JSONObject)parser.parse(json);
		
		this.item = (JSONArray)obj.get("records");
		System.out.println("***JSONArray: " + item.size());
		
		for(int i = 0; i < item.size(); i++) {
			LibraryVO lVO = new LibraryVO();
			JSONObject tmp = (JSONObject)item.get(i);
			lVO.setLbrry_name((String)tmp.get("librry_name"));
			lVO.setLbrry_seq_no((Double)tmp.get("lbrry_seq_no"));
			list.add(lVO);
			System.out.println("완료5");
			
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		LibraryAPI lapi = new LibraryAPI("강남구립못골도서관");
		System.out.println(lapi.item);
	}
}