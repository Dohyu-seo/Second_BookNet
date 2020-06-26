package com.pageturner.cls.service;
/**
 * 이 클래스는 검색 결과를 처리할 클래스입니다.
 * @author 서동혁
 * @since 2020-06-25
 * @version v.1.0
 *
 */

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.pageturner.cls.dao.SearchDAO;
import com.pageturner.cls.vo.*;

@Service
public class SearchService {
	
	@Autowired
	SearchDAO sDAO;
	// 로그인 확인은 membSrvc에서 하고
	// 여기서는 검색결과를 가져올 SQL설정을 마무리하자.
	// 검색결과는 대소문자 구분 없이 진행 하도록 해야 한다.
	public void searchIdCk(MemberVO mVO, HttpSession session) {
	}
}
