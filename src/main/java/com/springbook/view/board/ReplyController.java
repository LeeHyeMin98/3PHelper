package com.springbook.view.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.reply.ReplyService;
import com.springbook.biz.board.reply.ReplyVO;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService replyService;
	
	//댓글 입력
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute ReplyVO vo, HttpSession session) {
		String uname=(String) session.getAttribute("uname");
		vo.setReplyer(uname);
		replyService.create(vo);
	}
	
	//댓글 목록
	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam int seq, ModelAndView mav) {
		List<ReplyVO> list =replyService.list(seq);
		//뷰이름 지정
		mav.setViewName("replyList.jsp");
		mav.addObject("list",list);
		return mav;
	}
	
	//댓글 목록(Json방식 처리: 데이터 리턴
	@RequestMapping("/listJson.do")
	public List<ReplyVO> listJson(@RequestParam int seq){
		List<ReplyVO> list =replyService.list(seq);
		return list;
	}

}
