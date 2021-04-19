<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">



	
	function introadd(){

				
			window.open("/introadd", "introaddch",
					"width=800, height=600"
						)
		}



</script>
<body>
			<div class="left">
 				<a href="/">
      			<img src="resources/img/cpname.jpg" style="width:60%; height:30%; ">
      			</a>
     		</div>
 
 			<div class="right">
	 			
	    		<div class="right1">
	    			 <a href="/intro" style="text-decoration:none" >소개
	    			 </a>
	       		</div>
	       		
	     		<div class="right2">   
	       			 <a href="/insta" style="text-decoration:none">찌녕별
	       			 </a>
	       		</div>
	       		
	       			<c:choose>
	       				<c:when test=	"${empty name }"><p style="font-size:11px;">
	       			가입문의는 dydb07@naver.com 으로 연락주세요</p>
	       			</c:when>
					<c:when test ="${not empty name }">
				
				<div class="right3">&nbsp;
				</div>
			
				<div class="right4">
				
					<div class="box">
		   				<img class="profile" src="/resources/img/${profile }"> 
					</div>
				
				</div>
			
				<div class="right5">${name }
				</div>
	       			
				<div class="right6">
					<a href="/logout?intname=${name}">로그아웃
					</a><br/><br/>
					<a href="/instaaddhome">찌스타 등록</a>
					<br/><br/>
					<c:choose>
					<c:when test="${name == '지녕이' }">
					<a href="javascript:introadd()">멤버등록</a>
					</c:when>
					</c:choose>	
				</div>
						</c:when>
						</c:choose>
			</div>             
  
  
</body>
<style>

	
	html,body{height:100%;}
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
    
      div.left {
      padding:2%;
        width: 10%;
        float: left;
        box-sizing: border-box;
      }
      
      div.right{
      padding:2%;
      font-size:130%;
      text-align: center;
      	 width: 70%;
        float: right;
        box-sizing: border-box;
      }
      
      
       div.right1{
        width: 20%;
        float: left;
        box-sizing: border-box;
      }
      
      div.right2 {
        width: 20%;
        float: left;
        box-sizing: border-box;
      }
      
      div.right3 {
        width: 25%;
        float: left;
        box-sizing: border-box;
      }
      
        div.right4 {
        width: 4%;
        height:100;
        float: left;
        box-sizing: border-box;
      }
       div.box {
	    width: 100%;
	    height:100%; 
	    border-radius: 70%;
	    overflow: hidden;
		}
		img.profile {
	    width: 100%;
	    height: 100%;
	    object-fit: cover;
		}
      
      div.right5 {
      	padding:1.5%;
        width: 8%;
        float: left;
        box-sizing: border-box;
        font-size:3.5%;
      }
      
      div.right6 {
     	 padding:1%;
      	font-size:1%;
        width: 10%;
        float: right;
        box-sizing: border-box;
      }
      
      </style>
</html>