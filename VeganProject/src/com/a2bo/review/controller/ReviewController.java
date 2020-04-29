/*package com.a2bo.review.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.a2bo.member.model.vo.Member;
import com.a2bo.review.model.service.ReviewService;
import com.a2bo.review.model.vo.Review;
import common.util.FileUtil;
import common.vo.UploadFile;

public class ReviewController {
   ReviewService rs = new ReviewService();
   
   public ModelAndView ReviewList(HttpServletRequest request) {
	   ModelAndView mav = new ModelAndView();
	int currentPage = 1;
	int cntPerPage = 5;
	String orderby = "noticeno";
	
	if(request.getParameter("cPage")!=null) {
		currentPage = Integer.parseInt(request.getParameter("cPage"));
	}
	
	if(request.getParameter("cntPerPage") !=null) {
		cntPerPage = Integer.parseInt(request.getParameter("cntPerPage"));
	}
	   Map<String, Object > res = rs.selectNoticeList(orderby, currentPage, cntPerPage);
	   System.out.println(res.get("nlist").toString());
	   mav.addObject("paging",res.get("paging"));
	   mav.addObject("ndata",res.get("nlist"));
	   mav.setView("board/boardList");
	   return mav;
   }
   
   public ModelAndView noticeDetail(HttpServletRequest request) {
	   ModelAndView mav = new ModelAndView();
	   int reivewId = Integer.parseInt(request.getParameter("reviewId"));
	   Review review = rs.selectReview(reviewId);
	   mav.addObject("review", review);
	   mav.setView("board/boardView");
	   
	   return mav;
   }

   public ModelAndView notice(HttpServletRequest request) {

      ModelAndView mav = new ModelAndView();
      mav.setView("board/boardForm");
      return mav;
   }

   public ModelAndView noticeUpload(HttpServletRequest request) throws IOException {

      ModelAndView mav = new ModelAndView();
      Member m = (Member) request.getSession().getAttribute("loginInfo");

      String uploadFolder = "resources/upload";

      UploadFile file = new FileUtil().fileUpload(uploadFolder, request);

      if (file.isSuccess()) {
         Notice notice = new Notice();
         notice.setNoticeTitle(file.getmRequest().getParameter("noticeTitle"));
         notice.setNoticeContent(file.getmRequest().getParameter("noticeContent"));
         notice.setNoticeWriter(m.getM_id());
         notice.setOriginal_filepath(file.getOrginalFileName());
         notice.setRename_filepath(file.getRenameFileName());

         //더미데이터 작성코드
         for(int i =0; i<50; i++) {
        	 notice.setNoticeTitle(i+"번째 게시물 입니다.");
        	 ns.noticeUpload(notice);
         }
         
         if (ns.noticeUpload(notice) > 0) {
            mav.addObject("alertMsg", "게시글 등록이 완료되었습니다.");
            mav.addObject("url", "/servletBM/notice/noticelist.do");
            mav.setView("common/result");
         } else {
            mav.addObject("alertMsg", "게시글 등록 중 오류가 발생했습니다.");
            mav.addObject("back", "back");
            mav.setView("common/result");
         }

      } else {
         mav.addObject("alertMsg", "게시글 등록 중 오류가 발생했습니다.");
         mav.addObject("back", "back");
         mav.setView("common/result");

      }

      return mav;

   }
 
public ModelAndView noticeDownload(HttpServletRequest request) {
	
ModelAndView mav = new ModelAndView();
String readFolder
=request.getSession().getServletContext().getRealPath("/resources/upload");
String path = readFolder +"/" + request.getParameter("rfname");
String ofname = request.getParameter("ofname");

mav.addObject("path",path);
mav.addObject("ofname", ofname);
mav.setView("file");

return mav;
}   
   
   
   
   
   

}*/