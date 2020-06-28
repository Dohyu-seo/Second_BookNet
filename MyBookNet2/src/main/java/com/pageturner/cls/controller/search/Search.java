package com.pageturner.cls.controller.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class Search {
	
	// 검색한 결과 보여주기(ALL)
	@RequestMapping("/searchAll.cls")
	public ModelAndView searchAll(ModelAndView mv) {
		String view = "search/searchAll";
		mv.setViewName(view);
		return mv;
	}
	// 검색한 결과 보여주기(book)
	@RequestMapping("/searchBook.cls")
	public ModelAndView searchBook(ModelAndView mv) {
		String view = "search/searchBook";
		mv.setViewName(view);
		return mv;
	}
	// 검색한 결과 보여주기(Hash)
	@RequestMapping("/searchHash.cls")
	public ModelAndView searchHash(ModelAndView mv) {
		String view = "search/searchHash";
		mv.setViewName(view);
		return mv;
	}
	// 검색한 결과 보여주기(Member)
	@RequestMapping("/searchMember.cls")
	public ModelAndView searchMember(ModelAndView mv) {
		String view = "search/searchMember";
		mv.setViewName(view);
		return mv;
	}
}
