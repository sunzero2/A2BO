<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img style="margin-left: 30%; margin-top: 7%;" src="http://placehold.it/300x300">
	<div style="text-align: center; font-size: 30px; margin-top: 13%; font-weight: 900;">
		${isSuccess}
	</div>
	<div style="text-align: center; margin-top: 5%; font-size: 22px;">
		${sendMsg}
	</div>

	<c:if test="${loginInfo != null}">
		<script>
			window.open("http://localhost:8787/vgan/welcome", "_parent").parent.close();
		</script>
	</c:if>
	
	<c:if test="${loginInfo == null}">
		<div>로그인에 실패하였습니다. 동일 문제 현상이 지속적으로 발생하는 경우, 고객센터로 문의해주세요.</div>
	</c:if>
</body>
</html>