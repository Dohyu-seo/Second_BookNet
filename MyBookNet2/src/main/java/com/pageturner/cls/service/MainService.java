package com.pageturner.cls.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageturner.cls.dao.MainDAO;
import com.pageturner.cls.vo.MainVO;
import com.pageturner.cls.vo.PostsVO;

/**
 * 이 클래스는 Main 컨트롤러에 들어온 요청에 대한 dao 처리를 해주기 위한 서비스클래스입니다.
 * @author leeseulkim
 * @since 17th Jun 2020
 * @version v.1.0
 *
 */

@Service
public class MainService {
	@Autowired
	MainDAO mainDAO;
	
	//로그인한 회원용 메인게시글화면  
	public List<PostsVO> membMain(HttpSession session){
		List<PostsVO> list = null;

		//로그인되어있는지 확인
		String id = (String) session.getAttribute("SID");
		if(id == null || id.length() == 0) {
			//세션에 로그인 기록이 남아있지 않다면, controller에 null을 반환시킨다.
			list = null;
		} else {
			//로그인되어있을때 dao 호출 
			list = mainDAO.showMemMain(id);
		}
		
		return list;
	}
	
	//가장 많이 참조된 도서 목록 (비회원용)
	public List<MainVO> mostRefRank() {
		List<MainVO> list = mainDAO.oftenList();
		return list;
	}
	
}
