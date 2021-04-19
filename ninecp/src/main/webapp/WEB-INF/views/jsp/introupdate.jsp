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

	function introupdateCheck(){
		if(event.keyCode == 13){
		if(document.introupdate.intname.value==""){
			alert("이름을 입력해주세요");
			return false;
			}
		if(document.introupdate.intint.value==""){
			alert("소개글을 입력해주세요");
			return false;
			}
		if(document.introupdate.intimg.value ==""){
			alert("사진을 선택해주세요.");
			return false;
			}
		if(document.introupdate.intpass.value ==""){
			alert("비밀번호를 선택해주세요.");
			return false;
			}
		if(document.introupdate.intpasscheck.value ==""){
			alert("비밀번호 확인을 해주세요.");
			return false;
			}
		if(document.introupdate.intpass.value != document.introupdate.intpasscheck.value){
			alert("비밀번호를 한번더 확인해주세요.")
			return false;
			}
		
		else{
			window.opener.name="parentPage";
			document.introupdate.target="parentPage";
			document.introupdate.action="/introupdate";
			document.introupdate.submit();
			self.close();
		}
			}
		else{
			false;
		}
	}
	
</script>
</head>
<style>
	div.jinstar {
        width: 90%;
        height: 700px;
    }
     div.jinstarleft1 {
        width: 5%;
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
        width: 40%;
        float: right;
        height: 700px;
        box-sizing: border-box;
    }
    div.jinstarright1{
    	width:100%; height:45%;
    }
    div.jinstarright2{
	    width:100%; height:20%;
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
			<div class="jinstar">			
				
				<div class="jinstarleft1">
				</div>
				
					<form
					method="post"
					enctype="multipart/form-data"
					name="introupdate"
					onkeypress="introupdateCheck()"
					>
			
				<div class="jinstarleft2">
					<img id = "preview"width=99%; height=80%; src="/resources/img/${introup.intimg }">
					<input type = "file" name = "intimg" onchange="readurl(this)">
				</div>
				
				<div class="jinstarright">
				
					<div class="jinstarright1">
						<input type="hidden" name="intnum" value="${introup.intnum }">
						<input type = "text" style="word-wrap:break-word;width:100%; height:15%;break-all;"
						Placeholder="이름" name = "intname" value="${introup.intname }" readonly>
						<input type = "text" style="word-wrap:break-word;width:100%; height:30%;break-all;"
						Placeholder="소개글" name = "intint" value="${introup.intint }">
						<input type = "password" style="word-wrap:break-word;width:100%; height:15%;break-all;"
						Placeholder="비밀번호" name = "intpass">
						<input type = "password" style="word-wrap:break-word;width:100%; height:15%;break-all;"
						Placeholder="비밀번호를 한번 더 입력해주세요" name = "intpasscheck">
						<br><br><br>
					</div>
					
					<div class="jinstarright2">
					</div>
				</div>
				
				</form>
			</div>

</body>
</html>







