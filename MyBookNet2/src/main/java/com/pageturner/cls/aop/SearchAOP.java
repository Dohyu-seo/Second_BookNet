package com.pageturner.cls.aop;
/**
 * search뷰에 반복적으로 체크해야할 기능을 넣은 AOP다
 * @author 서동혁
 * @since  2020-06-29
 * @version v.1.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pageturner.cls.dao.MemberDAO;
import com.pageturner.cls.service.MemberService;

@Component
@Aspect
public class SearchAOP {
	@Autowired
	MemberService membSrvc;
	@Autowired
	MemberDAO mDAO;
	
	@Before("execution(* com.pageturner.cls.controller.main.Main.showNonMain(..))")
	public void loginCk(JoinPoint join) {
		System.out.println("******   loginCk AOP **");
		// 뷰 지정
		String view = "main/non_main";
		
		Object[] obj = join.getArgs();
		
		HttpServletRequest req = (HttpServletRequest) obj[0];
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		// 로그인 유무 확인하기
			if(sid == null) {
				//로그인이 안 된 상태
				System.out.println("로그인이 안되어있넹?");
				((ModelAndView)obj[1]).setViewName(view);
				((ModelAndView)obj[1]).addObject("isLogin", false);
			}else {
				//로그인이 된 상태
				System.out.println("로그인이 되어있넹?");
				((ModelAndView)obj[1]).setView(new RedirectView("/cls/main/main.cls"));
				((ModelAndView)obj[1]).addObject("isLogin", true);
			}
	}
	// 검색했을 때 session을 담아올 aop
	@Before("execution(* com.pageturner.cls.controller.search.Search.search*(..))")
	public void session(JoinPoint join) {
			System.out.println("search AOP 실행됨 - 기능미지정");
	}
}
