package com.ly.novel.web;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.novel.entity.Chapter;
import com.ly.novel.service.ChapterService;
import com.ly.novel.vo.ChapterVo;

@Controller
public class ChapterController {
	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping(value={"/chapter/read/{bid}/{chaid}.html","/chapter/query/{bid}/{chaid}"})
	public String queryChapterById(@PathVariable Integer bid,@PathVariable  Integer chaid,String fromPage,Model model) {
		ChapterVo chapterVo=chapterService.queryChapterVo(bid, chaid);
		int frontChapterId=chapterService.queryfrontChapterId(bid,chaid);
	    int nextChapterId=chapterService.querynextChapterId(bid,chaid);
		if(null!=chapterVo){
			model.addAttribute("origin", "forward");
			model.addAttribute("chapterVo", chapterVo);
			Map<String,Integer> frontAndNextchapterIdInfo=new HashMap<String,Integer>();
			frontAndNextchapterIdInfo.put("frontChapterId", frontChapterId);
			frontAndNextchapterIdInfo.put("nextChapterId", nextChapterId);
			model.addAttribute("frontAndNextchapterIdInfo", frontAndNextchapterIdInfo);
			//request.getRequestDispatcher(fromPage+".jsp?bid="+String.valueOf(bid)+"&chaid="+String.valueOf(chaid)+"").forward(request, response);
		}
		
		if(null == fromPage || "".equals(fromPage))
			return "forward:/chapter.jsp?bid="+bid+"&chaid="+chaid;
		else
			return "forward:/"+fromPage+".jsp?bid="+bid+"&chaid="+chaid;
	}
	
	
	@RequestMapping(value="/chapter/add")
	public String addChapter(Integer bid,String title,String contents) {
		Chapter chapter=new Chapter(bid,title,contents,new Date());
		boolean result=chapterService.addChapter(chapter);
		return "redirect:/writer/addChapter.jsp?bid="+bid;
	}
	
	
	@RequestMapping(value="/chapter/delete")
	public String delChapter(Integer bid,Integer chaid,Integer currentPage) {
		boolean result=chapterService.delChapterById(bid,chaid);
		return "redirect:/writer/novel_list.jsp?currentPage="+currentPage+"&bid="+bid;
	}
	
	
	@RequestMapping(value="/chapter/update")
	public String updateChapter(HttpServletRequest request) {
		int bid=Integer.parseInt(request.getParameter("bid"));
		int chaid=Integer.parseInt(request.getParameter("chaid"));
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		String fromPage=request.getParameter("fromPage");
		Chapter chapter=new Chapter();
		chapter.setBid(bid);
		chapter.setChaid(chaid);
		chapter.setTitle(title);
		chapter.setContents(contents);
		boolean result=chapterService.updateChapter(chapter);
//		queryChapterById(bid,chaid, fromPage, null);
		return  "redirect:/chapter/query/"+bid+"/"+chaid+"?fromPage="+fromPage;
	}



	
}
