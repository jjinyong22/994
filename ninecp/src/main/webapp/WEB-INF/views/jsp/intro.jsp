<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
figure.snip1432 {
  font-family: 'Raleway', Arial, sans-serif;
  color: #fff;
  position: relative;
  overflow: hidden;
  margin-left:2%;
  height:100%;
  width: 100%;
  background: #000000;
  color: #ffffff;
  text-align: left;
}
figure.snip1432 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.6s ease;
  transition: all 0.6s ease;
}
figure.snip1432 img {
	height:100%;
  width: 100%;
  -webkit-transition: opacity 0.35s;
  transition: opacity 0.35s;
}
figure.snip1432 figcaption {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
figure.snip1432 figcaption > div {
  height: 100%;
  overflow: hidden;
  width: 100%;
  position: relative;
}
figure.snip1432 h2,
figure.snip1432 h3 {
  margin: 0;
  position: absolute;
  left: 0;
  padding: 0 30px;
  text-transform: uppercase;
}
figure.snip1432 h2 {
  font-weight: 900;
  top: 0;
}
figure.snip1432 h3 {
  font-size: 1em;
  bottom: 0;
  font-weight: 5;
}
figure.snip1432 h3:nth-of-type(2) {
  opacity: 0;
  -webkit-transform: translateY(150%);
  transform: translateY(150%);
}
figure.snip1432 a {
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  position: absolute;
}
figure.snip1432:hover img,
figure.snip1432.hover img {
  opacity: 0.3;
  -webkit-filter: grayscale(100%);
  filter: grayscale(100%);
}
figure.snip1432:hover figcaption h3:first-of-type,
figure.snip1432.hover figcaption h3:first-of-type {
  -webkit-transform: translateY(150%);
  transform: translateY(150%);
  opacity: 0;
}
figure.snip1432:hover figcaption h3:nth-of-type(2),
figure.snip1432.hover figcaption h3:nth-of-type(2) {
  opacity: 1;
  -webkit-transform: translateY(0%);
  transform: translateY(0%);
}
</style>
<script type="text/javascript">

	function loginCheck(){
		alert("안녕하세요~");
	}
</script>
<body>
			<div class="menubar">
				<%@include file="menu.jsp" %>
			</div>
			
			<div style="height:25%; text-align:right; ">
			</div>
			
				<c:forEach items="${introlist}" var="introlist">
	
			<div style="width:25%; height:90%; float:left;">
					<figure class="snip1432">
					
					<img hspace="3"src="resources/img/${introlist.intimg }" width=100%; height=100%;>
					<figcaption>
			    <div style="height:50%;">
			    
					<h3></h3>	
			      	<h3>${introlist.intname }
			      	
			      	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
					
					${introlist.intint }<br/>
						<form action="login" method="post" name="loginform" onsubmit="loginCheck()">
						<input type="hidden" value="${introlist.intpass }" name="intpass">
						<input type="hidden" value="${introlist.intname }" name="intname">
					   	<input type="hidden" value="${introlist.intimg }" name="profile">
						<input type="password" name="loginpass" Placeholder="비밀번호를 입력해주세요">
					</form>
					</h3>
					
			    </div>
			  		</figcaption>
					</figure>
			</div>
			
				</c:forEach>

</body>
</html>