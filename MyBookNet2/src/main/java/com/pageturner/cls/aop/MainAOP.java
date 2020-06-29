package com.pageturner.cls.aop;
/**
 * Main뷰에 반복적으로 체크해야할 기능을 넣은 AOP다
 * @author 서동혁
 * @since  2020-06-29
 * @version v.1.0
 */
import javax.servlet.http.*;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Component
@Aspect
public class MainAOP {
	
	// 로그아웃해버리기~~
	@Before("execution(* com.pageturner.cls.controller.member.Member.logoutProc(..))")
	public void logOut(JoinPoint join) {
		System.out.println("로그아웃 하러 왔니~?");
		String view = "/cls/member/login.cls";
		// 오브젝트 담을 배열 만들긔
		Object[] obj = join.getArgs();
		
		// 세션 뽑긔
		HttpServletRequest req = (HttpServletRequest) obj[0];
		HttpSession session = req.getSession();
		RedirectView rv = null;
		// sid 세션 없애버릐기
		session.removeAttribute("SID");
		
		// 로그아웃이 안대써
		if(session.getAttribute("SID") != null) {
			view = "/cls/main/main";
		}
		// 정상 로그아웃대써
		rv = new RedirectView(view);
		((ModelAndView)obj[1]).setView(rv);
	}
}