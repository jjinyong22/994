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
	div.jinstar {
        width: 80%;
        height: 700px;
        float:left;
/*         border: 1px solid #000; */
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
    	text-align:left;
        width: 30%;
        float: right;
        height: 700px;
        box-sizing: border-box;
    }
    
    div.jinstarright1{
    	width:100%; height:6%;
    	border-bottom: 1px solid grey;
    }
    div.jinstarright2{
    	width:100%; height:15%;
    	font-size:3%;
    }
    div.jinstarright3{
	    width:100%; height:50%;
		border-bottom: 1px solid grey;
		overflow-y:scroll;
		-ms-overflow-style: none;
    }
     div.jinstarleftimg{
    	width:100%;
    	height:100%;
    	 float: left;
    	}
     div.jinstarleftimg1{
    	width:10%;
    	height:100%;
    	 float: left;
    
    	} 	
    div.jinstarleftimg2{
    	padding-top: 3%;
    	padding-left: 1%;
    	
    	font-size:8%;
    	width:80%;
    	height:100%;
    	 float: left;
    
    	}
    
    ::-webkit-scrollbar {
		display:none;
	} 
    
    div.jinstarright2reply1{
	    width:100%; height:12%;
    }
    div.jinstarright2reply2{
	    width:100%; height:5%;
	    text-align:right;
	    font-size:8%;
    }
    
    
 	div.jinstarright4{
 		width:100%; height:10%;
    }
</style>
<script type="text/javascript">
	function replyCheck(){

		if(event.keyCode == 13){
			
			if(document.replywrite.replywriter.value ==""){
				alert("작성자를 입력해주세요.");
				return false;
			}
		if(document.replywrite.replycontent.value==""){
				alert("댓글을 입력해주세요");
				return false;
			}
		else{ document.replywrite.submit();
		}
			}
		else{
				false;}
		
		}
</script>

<body>
			<div class="menubar" >
				<%@include file="menu.jsp" %>
			</div>
			
			<div style="height:25%; text-align:right;">
			</div>
	
			<div class="jinstar">
			
				<div class="jinstarleft1">
				</div>
				
				<div class="jinstarleft2">
					<img hspace="3"src="/resources/img/${read.insta_image }" width=99%; height=650;>
				</div>
		
				<div class="jinstarright">
		
					<div class="jinstarright1">
						
						<div class="jinstarleftimg">
							
							<div class="jinstarleftimg1">
								
								<div class="box" style="background: #BDBDBD;">
					   				<img class="profile" src="/resources/img/${read.insta_profile }">
								</div> 
							
							</div>
							
							<div class="jinstarleftimg2">${read.insta_name }
							</div>
							
						</div>
						
					</div>
		
		
					<div class="jinstarright2">
						<br>${read.insta_int }
					</div><hr>
	
					<div class="jinstarright3">
    					<c:forEach items="${replyList}" var="replyList">
						
						<div class="jinstarright2reply1">
							
							<div class="jinstarleftimg">
						
								<div class="jinstarleftimg1">
								
					       			<div class="box" style="background: #BDBDBD;">
				   						<img class="profile" src="/resources/img/${replyList.reply_img }">
				   					</div> 
				   					
								</div>
								
								<div class="jinstarleftimg2">
									 <b>${replyList.writer}</b>&nbsp;&nbsp;&nbsp;${replyList.content}
								</div>
								
							</div> 
							
						</div>
						
						<div class="jinstarright2reply2">
							<form action="deletereply" method="post" onsubmit="return delete()">
					 			<input type="hidden" name="rno" value="${replyList.rno }" >
								<fmt:formatDate value="${replyList.regdate}" pattern="MM-dd" />
					 	 			<c:choose>
									<c:when test="${name == replyList.writer }">
										<input type="IMAGE" src = "resources/img/xicon.jpg" width = "10" height = "10" value="Submit">
									</c:when>
									</c:choose>
						 			<input type="hidden" name="bno" value="${read.insta_bno }">
							</form>
					 	</div>
				    	
				    	</c:forEach> 
				      
					</div>
					
					<div class="jinstarright4">
						<form action="reply_write" method="post" name="replywrite">
							<input type="hidden" name="bno" value="${read.insta_bno }">
							<c:choose>
							<c:when test="${empty name }">
							<input style="width:100%; height:50px;border:none; text-align:center;"
									 type = "text" value="로그인 후 이용해주세요." readonly
									 	onkeypress="return false;">
							</c:when>
							<c:when test="${not empty name }">
							<input style="width:15%; height:50px;border:none;" type = "text" 
									name= "replywriter" value=${name } readonly>
							<input type="hidden" name="reply_img" value=${profile }>
							<input style="width:80%;height:5%;border:none; text-align:center;" type = "text"
									 name= "replycontent" Placeholder="댓글" onkeypress="replyCheck()">
							</c:when>
							</c:choose>
						</form>		 
					</div>
				
				</div>
			
			</div>		
				
				<c:choose>
				<c:when test="${name == read.insta_name }">
				<a href="deleteinsta?bno=${read.insta_bno }">삭제</a>
				</c:when>
				</c:choose>

</body>
</html>