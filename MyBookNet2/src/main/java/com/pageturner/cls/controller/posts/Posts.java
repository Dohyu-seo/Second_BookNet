package com.pageturner.cls.controller.posts;
/**
 * 이 클래스는 게시글과 관련된 요청을 처리해주기 위한 컨트롤러입니다.
 * @author leeseulkim
 * @since 13th Jun 2020
 *
 */

import javax.servlet.http.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.*;

import com.pageturner.cls.dao.*;
import com.pageturner.cls.service.*;
import com.pageturner.cls.vo.*;

@Controller
@RequestMapping("/posts")
public class Posts {
	@Autowired
	PostsDAO pDAO;
	
	@Autowired
	PostsService postsSrvc;
	
	//게시물 상세보기 내 댓글리스트 비동기 통신
	@RequestMapping("/showCmtList.cls")
	@ResponseBody
	public List<PostsVO> showCmtList(int pno, HttpSession session) {
		PostsVO pVO = new PostsVO();
		pVO.setSid((String)session.getAttribute("SID")); //세션에 담긴 id 값 VO 클래스에 담기 
		pVO.setPno(pno);
		List<PostsVO> list = pDAO.showCmtList(pVO);
		System.out.println("###### pVO의 sid : " + pVO.getSid());
		System.out.println(list);
		return list;
	}
	
	//게시물 상세보기 내 댓글작성 비동기 통신
	@RequestMapping("/wrtCmt.cls")
	@ResponseBody
	public PostsVO wrtCmt(int pno, String id, String cbody, HttpSession session, PostsVO pVO) {
		id = (String)session.getAttribute("SID");
		
		//현재시간 받기
		Date date = new Date();
		
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		String cdate = form1.format(date);
		String ctime = form2.format(date);
		
		pVO.setId(id); //id값 vo 클래스에 담기
		pVO.setCdate(cdate); //댓글작성시간 vo 클래스에 담기
		pVO.setCtime(ctime);
		
		int cnt = pDAO.wrtCmt(pVO);
		pVO.setCnt(cnt);
		
		return pVO;
	}
	
	//댓글 삭제 비동기 통신 
	@RequestMapping("/delCmt.cls")
	@ResponseBody
	public int delCmt(int cno) {
		int rst = postsSrvc.delCmt(cno);
		System.out.println(rst);
		return rst;
	}
	
	//게시글 작성시 도서검색 결과 비동기통신 처리 
	@RequestMapping("/searchBook.cls")
	@ResponseBody
	public List<BookVO> searchBook(String searchword, BookVO bVO){
		String word = "%" + searchword + "%";
		List<BookVO> list = pDAO.searchBook(word);
		System.out.println(list.size());
		return list;
	}
}
