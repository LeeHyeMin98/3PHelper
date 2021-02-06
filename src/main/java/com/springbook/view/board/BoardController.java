package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardPager;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList();
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}

	//�Խñ� ���
	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(defaultValue="title") String searchOption, @RequestParam(defaultValue="") String keyword, @RequestParam(defaultValue="1")int curPage) throws Exception{
		//List<BoardVO> list = boardService.listAll( searchOption,keyword);
		
		//���ڵ��� ����
		int count = boardService.countArticle(searchOption,keyword);
		
		//������ ������ ���� ó��
		BoardPager boardPager = new BoardPager(count,curPage);
		int start = boardPager.getPageBegin();
		int end =boardPager.getPageEnd();
		
		List<BoardVO> list = boardService.listAll(start, end, searchOption,keyword);
		
		//�����͸� �ʿ� ����
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list); //list
		map.put("count", count); //���ڵ��� ����
		map.put("searchOption", searchOption); //�˻� �ɼ�
		map.put("keyword", keyword); //�˻�Ű����
		map.put("boardPager", boardPager);
		
	
		//ModelAndView
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("map",map); //�ʿ� ����� �����͸� mav�� ����
		
		mav.setViewName("list.jsp");//�並 list.jsp�� ����
		//mav.addObject("list",list);

		return mav;
		

		
	}
	
//	//�� �ۼ�ȭ��
//	@RequestMapping(value="write.do", method=RequestMethod.GET)
//	public String write() {
//		return "write.jsp";
//	}
//	// �� ���
//	@RequestMapping(value = "/insertBoard.do")
//	public String insertBoard(BoardVO vo) throws IOException {
//		// ���� ���ε� ó��
//		MultipartFile uploadFile = vo.getUploadFile();
//		if (!uploadFile.isEmpty()) {
//			String fileName = uploadFile.getOriginalFilename();
//			uploadFile.transferTo(new File("C:\\Users\\hmin\\Pictures" + fileName));
//		}
//
//		boardService.insertBoard(vo);
//		return "getBoardList.do";
//	}
	
	//�� �ۼ� �ۼ��ڸ� �α��� ����ڷ� ����
	@RequestMapping(value="insertBoard.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo, HttpSession session) throws Exception{
		//session�� ����� username�� writer�� ����
		
		String writer =(String) session.getAttribute("uname");
		
		//vo�� writer�� ����
		vo.setWriter(writer);
		
		boardService.insertBoard(vo);
	
		return "redirect:list.do";
	}
	

	// �� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "list.do";
	}

	// �� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(@RequestParam int seq) {
		boardService.deleteBoard(seq);
		return "list.do";
	}

	// �� �� ��ȸ
	/*
	 * @RequestMapping("/getBoard.do") public String getBoard(BoardVO vo, Model
	 * model) { model.addAttribute("board", boardService.getBoard(vo)); // Model ����
	 * ���� return "getBoard.jsp"; // View �̸� ���� }
	 */
	
	//�Խñ� �� ���� ��ȸ, �Խñ� ��ȸ�� ���� ó��
	@RequestMapping(value="/view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int seq, HttpSession session) throws Exception{
		//��ȸ�� ���� ó��
		boardService.increaseViewcnt(seq, session);
		//��(������)+��(ȭ��)�� �Բ� �����ϴ� ��ü
		ModelAndView mav = new ModelAndView();
		//���� �̸�
		mav.setViewName("view.jsp");
		//�信 ������ ������
		mav.addObject("board",boardService.getBoard(seq));
		return mav;
	}
	

	// �˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}

	// �� ��� �˻�
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(BoardVO vo, Model model) {
//		// Null Check
//		if (vo.getSearchCondition() == null)
//			vo.setSearchCondition("TITLE");
//		if (vo.getSearchKeyword() == null)
//			vo.setSearchKeyword("");
//		// Model ���� ����
//		model.addAttribute("boardList", boardService.getBoardList(vo));
//		return "getBoardList.jsp"; // View �̸� ����
//	}
}
