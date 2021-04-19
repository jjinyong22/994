<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" 
		uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" 
		uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js">
</script>
<script type="text/javascript">
	function readurl(url){
		if(url.files && url.files[0]){
		var reader = new FileReader();
		reader.onload = function(e){
			$("#preview").attr('src',e.target.result);
			}
		reader.readAsDataURL(url.files[0]);
		}
	}


	function instaaddCheck(){
		if(document.instaadd.insta_IMAGE.value ==""){
			alert("사진을 선택해주세요.");
			return false;
			}
		if(document.instaadd.insta_int.value==""){
			alert("내용을 입력해주세요");
			return false;
			}
		else{document.instaadd.submit();
			}
		}
	
	
	
</script>
</head>
<style>
	div.jinstar {
        width: 80%;
        height: 700px;
    }
     div.jinstarleft1 {
        width: 15%;
        height: 700px;
	    float: left;
        box-sizing: border-box;
        
    }
    
    div.jinstarleft2 {
        width: 50%;
        height: 700px;
	    float: left;
        box-sizing: border-box;
    }
    div.jinstarright {
    	text-align:right;
 	    padding: 5% 2%;
        width: 30%;
        float: right;
        height: 700px;
        box-sizing: border-box;
    }
    div.jinstarright1{
    	width:100%; height:15%
    }
    div.jinstarright2{
	    width:100%; height:55%;
		overflow-y:scroll;
		-ms-overflow-style: none;
    }
    ::-webkit-scrollbar {
		display:none;
	} 
    
 	div.jinstarright3{
 		width:100%; height:10%;
    }
</style>
<body>
			<div class="menubar" >
				<%@include file="menu.jsp" %>
			</div>
			
			<div style="height:25%; text-align:right;">
			</div>
			
			<div class="jinstar">			
				
				<div class="jinstarleft1">
				</div>
				
					<form action="/instaadd" method ="post" enctype="multipart/form-data" name="instaadd"> 
			
				<div class="jinstarleft2">
					<img id = "preview"width=99%; height=650; src="/resources/img/camera.jpg">
					<input type = "file" name = "insta_IMAGE" onchange="readurl(this)">
				</div>
				
				<div class="jinstarright">

					<div class="jinstarright1">
						<input type="hidden" name="insta_name" value=${name }>
						<input type="hidden" name="profile" value="${profile }">
						<input type = "text" style="word-wrap:break-word;width:100%; height:100%;break-all;" name = "insta_int">
						<br><br><br>
						<input type ="button" value = "추가하기" onclick="instaaddCheck()"> 
					</div>
					
					<div class="jinstarright2">
					</div>
				</div>
				
					</form>
			</div>

</body>
</html>







