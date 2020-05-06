<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vgan/resources/css/revList.css"/>
</head>
<body>

<div class="review">
	  <h2><span>Review</span></h2>
</div> 
	
  	   <table class="reviewList">
       <caption></caption>
       <thead>
           <tr>
               <th>No.</th>
                <th width="400px" style="text-align-last: center;"><span>Title</span></td>
                <th width="100px"><span>starrate</span></th>
                <th width="100px"><span>Writer</span></th>
                <th width="100px"><span>Date</span></th>
            </tr>
       </thead>
       <tbody id="body">
       		<c:forEach items="${revList}" var ="rev">
            <tr>
                <td>${rev.reviewNo}</td>
                <td width="400px" style="text-align-last: center;">
   //method contents보여주는만들   <a href="/vgan/revContent?menuId=${resMenuinfo.menuId}">${resMenuinfo.reviewTitle}</a></td>
                <td width="100px">${request.starrate}</td>
                <td width="100px">${loginInfo.nickName}</td>
                <td width="100px">${rev.reviewDate}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
       
       <div class="paging">
       <a href= "/vgan/ReviewList" class="nav first">
       <i class ="fas fa-angle-double-left"></i>
       </a>
       <a href= "/vgan/ReviewList?cPage=${revList.paging.blockEnd-1}" class="nav prev">
       <i class="fas fa-angle-left"></i>
       </a>
       <c:forEach begin="${revList.paging.blockStart}" end="${revList.paging.blockEnd}" var="page">
       <a href="/vgan/ReviewList?cPage=${page}" class="num active"><span>${page}</span></a>
       </c:forEach>
        <a href= "/vgan/ReviewList?cPage=${revList.paging.blockEnd+1}" class="nav next">
       <i class="fas fa-angle-right"></i>
       </a>
        <a href= "/vgan/ReviewList?cPage=${revList.paging.lastPage}" class="nav last">
       <i class="fas fa-angle-double-right"></i>
       </a>      
       </div>
	
</body>
</html>