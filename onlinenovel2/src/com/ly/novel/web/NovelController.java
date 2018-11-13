package com.ly.novel.web;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.novel.entity.Admin;
import com.ly.novel.entity.Chapter;
import com.ly.novel.entity.Novel;
import com.ly.novel.entity.User;
import com.ly.novel.entity.category;
import com.ly.novel.service.AdminService;
import com.ly.novel.service.NovelService;
import com.ly.novel.service.ReplyService;
import com.ly.novel.service.VoteService;
import com.ly.novel.util.Page;
import com.ly.novel.util.PageUtil;
import com.ly.novel.vo.NovelVo;
import com.ly.novel.vo.ReplyVo;
import com.ly.novel.vo.ReviewVo;


@Controller
public class NovelController {
	@Autowired
	private AdminService  adminService;
	@Autowired
	private NovelService novelService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private VoteService voteService;
	
	@RequestMapping(value="/admin/{id}")
	public String queryAdmin(@PathVariable Integer id,Model model) {
		Admin admin=adminService.queryAdminById(id);
		System.out.println(admin);
		model.addAttribute("admin", admin);
		return  "forward:/list.jsp";
	}
	
	@RequestMapping(value="/category/list")
	public String queruCategory(Model model,@RequestParam(value="fromPage",required=false) String fromPage) {
		List<category> categorys=novelService.queryAllCategorys();
		model.addAttribute("origin","forward");
		model.addAttribute("categorys", categorys);
		if(null==fromPage || "".equals(fromPage))
			return  "forward:/head.jsp";
		else
			return "forward:/"+fromPage+".jsp";
		
	}
	@RequestMapping(value="/category/add")
	public String addCategory(String categoryname) {
		Date createTime=new Date();
		novelService.addCategory(categoryname,createTime);
		return "redirect:/category/list";
	}
	
	@RequestMapping(value="/category/delete/{cid}")
	public String delCategory(@PathVariable("cid") Integer cid) {
		novelService.delCategory(cid);
		return "redirect:/category/list";
	}
	
	@RequestMapping("/novel/list")
	public String novelQueryByPage(String fromPage,Integer currentPage,Model model) {
		int totalCount=novelService.getNovelsCount();
		try{
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		
		List<NovelVo> mList=novelService.queryNovelsByPage(page);
		page.setList(mList);
		model.addAttribute("origin", "forward");
		model.addAttribute("page", page);
		if("".equals(fromPage))
		  return  "forward:/novel.jsp";
		else
			return  "forward:/"+fromPage+".jsp";
			
	}
	@RequestMapping("/novel/category/query")
	public String queryCategoryNovelsByCid(String fromPage,Integer currentPage,Model model,Integer cid,String categoryname) {
		int totalCount=novelService.getNovelsCount();
		try{
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		
		List<NovelVo> mList=novelService.queryCategoryNovelsByCid(page,cid);
		page.setList(mList);
		model.addAttribute("categoryname", categoryname);
		model.addAttribute("origin", "forward");
		model.addAttribute("page", page);
		if("".equals(fromPage))
		  return  "forward:/category.jsp";
		else
			return  "forward:/"+fromPage+".jsp";
			
	}
	
	@RequestMapping("/novel/query")
	public String novelQuery(HttpServletRequest request,@RequestParam(value="fromPage",required=false) String fromPage,Integer bid,Model model) {
    	NovelVo novelVo=novelService.queryNovelById(bid);	
		List<ReplyVo> replyVos=replyService.findReplyByBid(bid);
		Page page=queryAllChapters(request);
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
	    model.addAttribute("bid", bid);
	    model.addAttribute("page", page);
	    model.addAttribute("novelVo", novelVo);
	    model.addAttribute("rList", replyVos);
	    model.addAttribute("createTime", sdf.format(novelVo.getPosttime()));
		model.addAttribute("origin", "forward");
		if(null==fromPage || "".equals(fromPage))
		  return  "forward:/detail.jsp";
		else
			return  "forward:/"+fromPage+".jsp";
			
	}
	private Page queryAllChapters(HttpServletRequest request){
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(request.getParameter("bid"));
		int totalCount=novelService.getChapterCount(bid);
		int currentPage=1;
		try{
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		List<Chapter> chapters=novelService.queryChaptersByPage(bid,page);
		page.setList(chapters);
		//request.setAttribute("page", page);	
        return page;	
	}
	
	@RequestMapping(value="/vote/add",method={RequestMethod.POST})
	  public @ResponseBody String addBookSelfByUser(HttpSession session,@RequestParam(required=false) Integer bid) {
			User currentUser=((User)session.getAttribute("user"));
			if(null!=currentUser){
				int userid=currentUser.getUserid();
				int voteStatus=voteService.addVote(userid,bid);
			     if(voteStatus==1)
						return "success";
		              else if(voteStatus==2)
						return "exist";
		              else if(voteStatus==0)
						return "fail";
				}
					return  "nologin";
	}
	
	@RequestMapping(value="/novel/search")
	private String  searchNovelInfoById(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="fromPage",required=false) String fromPage,String keyword,Model model){
		// TODO Auto-generated method stub
		 int totalCount=novelService.getNovelsCount();
		int currentPage=1;
		try{
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
			currentPage=currentPage>0?currentPage:1;
		}catch(Exception e){
			currentPage=1;
		}
		Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
		List<NovelVo> mList=novelService.querySearchNovelsByPage(page,keyword);
		page.setList(mList);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		model.addAttribute("origin", "forward");
		if(null==fromPage || "".equals(fromPage))
		  return  "forward:/search.jsp";
		else
			return  "forward:/"+fromPage+".jsp";
	}
	
	@RequestMapping(value="/novel/delete/{bid}")
	public String delNovel(@PathVariable("bid") Integer bid,@RequestParam(value="fromPage",required=false) String fromPage){
		novelService.delNovelById(bid);
		
		if(null==fromPage || "".equals(fromPage))
			return "redirect:/writer/myNovel.jsp";
		else
			return "redirect:/"+fromPage+".jsp";
	}
	
	@RequestMapping(value="/novel/queryAll")
	public String queryAllNovelsByUserid(HttpSession session,Model model) {
		User currentUser=null;
		currentUser=(User)session.getAttribute("user");
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			List<Novel> novels=novelService.queryAllNovelsByUserid(userid);
			if(null!=novels){
				model.addAttribute("novels", novels);
				model.addAttribute("origin", "forward");
			}
			return  "forward:/writer/myNovel.jsp";
		  }else
			
			  return  "redirect:/login.jsp";
		
	}
	
	@RequestMapping(value="/novel/finish/{bid}")
	public String  finishNovelById(@PathVariable("bid") Integer bid)  {
		// TODO Auto-generated method stub
		boolean result=novelService.finishNovelById(bid);
		if(result)
			return "redirect:/writer/myNovel.jsp";
		else	
			return "redirect:/writer/addNovel.jsp";
	}
	
	@RequestMapping(value="/novel/add")
	public String addNovel(HttpServletRequest request) {
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		if(null!=currentUser){
			int userid=currentUser.getUserid();
			int cid=Integer.parseInt(request.getParameter("cid"));
			String  bookname=request.getParameter("bookname");
			String  bookintroduction=request.getParameter("bookintroduction");
			String postip=request.getRemoteAddr();
			Date posttime=new Date();
			Novel novel=new Novel();
			novel.setUserid(userid);
			novel.setBookname(bookname);
			novel.setBookintroduction(bookintroduction);
			novel.setPostip(postip);
			novel.setPosttime(posttime);
			novel.setCid(cid);
			novelService.addNovel(novel);
			return "redirect:/writer/addNovel.jsp";
		}else
			return "redirect:/login.jsp";		
	}
	
	@RequestMapping(value="/novel/update")
	public String updateNovel(HttpServletRequest request) {
		User currentUser=null;
		currentUser=(User)request.getSession().getAttribute("user");
		Admin currentAdmin=null;
		currentAdmin=(Admin)request.getSession().getAttribute("admin");
		if(null!=currentUser||null!=currentAdmin){
			int bid=Integer.parseInt(request.getParameter("bid"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			String bookname=request.getParameter("bookname");
			String bookintroduction=request.getParameter("bookintroduction");
			String fromPage=request.getParameter("fromPage");
			Novel novel=new Novel();
			novel.setBid(bid);
			novel.setCid(cid);
			novel.setBookname(bookname);
			novel.setBookintroduction(bookintroduction);
			boolean result=novelService.updateNovel(novel);
			//novelQuery(request, fromPage, bid, null);
			return "redirect:/novel/query?bid="+bid+"&fromPage=writer/updateNovel";
		}else{
			return "redirect:/login.jsp";
		
		}
	}
	
	@RequestMapping(value="/novel/manageall")
	public String manageAllNovels(HttpSession session,Model model,@RequestParam(value="currentPage",required=false) Integer currentPage) {
		Admin currentAdmin=(Admin)session.getAttribute("admin");
		  if(null!=currentAdmin){
			  int totalCount=novelService.getNovelsCount();
				currentPage=1;
				try{
					currentPage=currentPage>0?currentPage:1;
				}catch(Exception e){
					currentPage=1;
				}
				Page page=PageUtil.createPage(PageUtil.DEFAULT_EVERYPAGE, totalCount, currentPage);
				List<NovelVo> novelVos=novelService.queryNovelsByPage(page);
				
				if(null!=novelVos){
					page.setList(novelVos);
					model.addAttribute("page", page);
					model.addAttribute("origin", "forward");
		  }
				return "forward:/admin/novelManager.jsp";
				
		  }else
			  	return "redirect:/admin/admin_login.jsp";
	}
	
	
	@RequestMapping(value="/novel/apply/queryall")
	public String queryAllReviews(HttpSession session,Model model) {
		Admin currentAdmin=(Admin)session.getAttribute("admin");
		  if(null!=currentAdmin){
			  List<ReviewVo> reviewVos=novelService.queryAllReviews();
			  model.addAttribute("reviewVos", reviewVos);
			  model.addAttribute("origin", "forward");
			  return "forward:/admin/reviewList.jsp";
		  }
		return "redirect:/admin/admin_login.jsp";
		
	}
	
	
	@RequestMapping(value="/novel/apply/query")
	public String queryReview(HttpSession session,Model model,Integer rid) {
		Admin currentAdmin=(Admin)session.getAttribute("admin");
		  if(null!=currentAdmin){
			  ReviewVo reviewVo=novelService.queryAllReviewById(rid);
			  model.addAttribute("reviewVo", reviewVo);
			  model.addAttribute("origin", "forward");
			  return "forward:/admin/reviewUser.jsp";
		  }
		return "redirect:/admin/admin_login.jsp";
	}
	
	@RequestMapping(value="/novel/apply/review")
	public String doReview(Integer rid,Integer userid,String reviewStatus) {
		boolean result=novelService.reviewNovel(rid, userid, reviewStatus);
		return "redirect:/novel/apply/queryall";
	
	}
	
	
}
	
