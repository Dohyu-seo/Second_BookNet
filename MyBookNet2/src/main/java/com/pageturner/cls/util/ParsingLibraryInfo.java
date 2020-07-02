package com.pageturner.cls.util;

/**
 * 이 클래스는 api로부터 받아온 도서정보를 파싱하여 vo에 담아줄 util 클래스입니다.
 * @author leeseulkim
 * @since 27th Jun 2020
 * @version v.1.0
 *
 */

import java.util.*;

import com.google.gson.*;
import com.pageturner.cls.vo.*;

public class ParsingLibraryInfo {
	
	public JsonParser jPar;
	public JsonObject jObj, jlib;
	public JsonArray jArr;

	public ArrayList<LibraryVO> parsingLibraryInfo(String json) throws Exception {
		ArrayList<LibraryVO> list = new ArrayList<LibraryVO>();
		
		jPar = new JsonParser();
		jObj = (JsonObject)jPar.parse(json);
		jlib = jObj.get("SeoulPublicLibraryInfo").getAsJsonObject();
		jArr = jlib.get("row").getAsJsonArray();
		System.out.println(jlib);
		System.out.println("row 사이즈 : " + jArr.size());
		
		for(int i = 0; i < jArr.size(); i++) {
			LibraryVO lVO = new LibraryVO();
			JsonObject obj = (JsonObject) jArr.get(i);
			
			lVO.setLbrry_name(obj.get("lbrry_name").getAsString());
			lVO.setHmpg_url(obj.get("hmpg_url").getAsString());
			lVO.setFdrm_close_date(obj.get("fdrm_close_date").getAsString());
			lVO.setAdres(obj.get("adres").getAsString());
			lVO.setTel_no(obj.get("tel_no").getAsString());
			lVO.setXcnts(obj.get("xcnts").getAsDouble());
			lVO.setYdnts(obj.get("ydnts").getAsDouble());
			
			list.add(lVO);
		}
		
		return list;
	}
}
