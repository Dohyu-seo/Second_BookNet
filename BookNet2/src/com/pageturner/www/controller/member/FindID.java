package com.pageturner.www.controller.member;

/**
 * 아이디 찾기 폼 요청
 * @author	이명환
 * @since	2020.05.26
 * 
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pageturner.www.controller.PageController;

public class FindID implements PageController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/findID.jsp";
		
		return view;
	}

}
