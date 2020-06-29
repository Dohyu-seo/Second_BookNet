package com.pageturner.cls.controller.search;
import java.util.List;

/**
 * 검색결과뷰로 이동시켜줄 컨트롤러다.
 * @author 서동혁
 * @since 2020-06-29
 * @version v.1.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pageturner.cls.service.SearchService;
import com.pageturner.cls.vo.SearchVO;

@Controller
@RequestMapping("/search")
public class Search {
	
	@Autowired
	SearchService sSrvc;
	
	// 검색한 결과 보여주기(ALL)
	@RequestMapping("/searchAll.cls")
	public ModelAndView searchAll(ModelAndView mv, HttpSession session, HttpServletRequest req) {
		// 뷰 지정
		String view = "search/searchAll";
		// 아이디 가져오기
		String sid = (String)session.getAttribute("SID");
		// 아아디세션 만료되었는지 확인하기
		if(sid != null) {
			System.out.println("컨트롤러에서 아이디확인 : " + sid);
			// 파라미터에서 검색값 가져오기
			String tmp = req.getParameter("searchinput");
			String keyword = "%" + tmp + "%";
			List<SearchVO> list = sSrvc.searchKey(keyword);
			
			//검색결과 콘솔
			System.out.println("검색 키워드 :"+ keyword);
//			// 검색된 값 세션에 담기s
//			session.setAttribute("KEYWORD", keyword);
			mv.addObject("KEYWORD", keyword);
			mv.addObject("LIST", list);
			mv.setViewName(view);
			return mv;
		}
		else {
			System.out.println("아이디세션 만료");
			view = "member/login";
			mv.setViewName(view);
			return mv;
		}
	}
	// 검색한 결과 보여주기(book)
	@RequestMapping("/searchBook.cls")
	public ModelAndView searchBook(ModelAndView mv, HttpSession session, HttpServletRequest req) {
		String view = "search/searchBook";
		// 아이디 가져오기
		String sid = (String)session.getAttribute("SID");
		// 아아디세션 만료되었는지 확인하기
		if(sid != null) {
			System.out.println(sid);
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("bookKey");
			//검색결과 콘솔
			System.out.println("책검색 키워드 :"+ keyword);
			// 검색된 값 세션에 담기
			session.setAttribute("KEYWORD", keyword);
			mv.setViewName(view);
			return mv;
		}
		else {
			System.out.println("아이디세션 만료");
			view = "member/login";
			mv.setViewName(view);
			return mv;
		}
	}
	// 검색한 결과 보여주기(Hash)
	@RequestMapping("/searchHash.cls")
	public ModelAndView searchHash(ModelAndView mv, HttpSession session, HttpServletRequest req) {
		String view = "search/searchHash";
		// 아이디 가져오기
		String sid = (String)session.getAttribute("SID");
		// 아아디세션 만료되었는지 확인하기
		if(sid != null) {
			System.out.println(sid);
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("hashKey");
			//검색결과 콘솔
			System.out.println("해시태그검색 키워드 :"+ keyword);
			// 검색된 값 세션에 담기
			session.setAttribute("KEYWORD", keyword);
			mv.setViewName(view);
			return mv;
		}
		else {
			System.out.println("아이디세션 만료");
			view = "member/login";
			mv.setViewName(view);
			return mv;
		}
	}
	// 검색한 결과 보여주기(Member)
	@RequestMapping("/searchMember.cls")
	public ModelAndView searchMember(ModelAndView mv, HttpSession session, HttpServletRequest req) {
		String view = "search/searchMember";
		// 아이디 가져오기
		String sid = (String)session.getAttribute("SID");
		// 아아디세션 만료되었는지 확인하기
		if(sid != null) {
			System.out.println(sid);
			// 파라미터에서 검색값 가져오기
			String keyword = req.getParameter("membKey");
			//검색결과 콘솔
			System.out.println("아이디검색 키워드 :"+ keyword);
			// 검색된 값 세션에 담기
			session.setAttribute("KEYWORD", keyword);
			mv.setViewName(view);
			return mv;
		}
		else {
			System.out.println("아이디세션 만료");
			view = "member/login";
			mv.setViewName(view);
			return mv;
		}
	}
}
