<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>아이디 찾기</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 200px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
	}
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
	}

    #btn-Yes{
        background-color: #e4932b;
        border: none;
    }
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
 
    .card-title{
        margin-left: 30px;
    }


    a{ 
    	color: #f58b34; text-decoration: none; 
    }

    .links{
        text-align: center;
        margin-bottom: 10px;
    }
    
    .checks{
    	color : red;
    }
    </style>
  </head>
   
  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:30rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:#f58b34;"><img src="/resources/img/rabbit_logo.png"/></h2>
		</div>
        
		<div class="card-body">
      <form action="findPw" class="form-signin" method="POST">
        <input type="text" name="member_id" id="member_id" class="form-control" placeholder="아이디" required><br>
        <input type="text" name="name" id="name" class="form-control" placeholder="이름" required><BR>
		<input type="text" name="email" id="inputEmailForm"  maxlength="30">
		<button onclick="emailAuthentication()" id="eamilAuthBtn" type="button" class="btnChk">인증 메일 보내기</button>
		<input type="text" name="authCode" id="inputAuthCode"  maxlength="10" disabled="disabled">
		<button onclick="authCodeCheck()" id="authCodeCheckBtn" type="button" disabled="disabled" class="btnChk">인증</button>
		<input type="hidden" name="authPass" id="authPass" value="false">
	        
	<p class="checks" id="checks">${findpw_checkf}</p><br/>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 찾기</button>
      </form>
      
		</div>
        <div class="links">
            <a href="memberId">아이디 찾기</a> | <a href="memberLogin">로그인</a> | <a href="memberRegist">회원가입</a>

        </div>
	</div>
  
  </body>
    <script type="text/javascript">
    
    function emailAuthentication(){
    	if (!emailValCheck()){
        	return false;
        }
    	var url = "confirmEmail.four?email=" + document.signUpForm.email.value;
    	var condition = "toolbar=no, location=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200"
    			open(url, "confirm", condition);
    }
    
    const form = document.signUpForm;

    function emailValCheck(){
    	var emailPattern= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	var email = form.email.value;
    	if(!check(emailPattern, email, "유효하지 않은 이메일 주소입니다.")) {
    		return false;
    	}
        return true;
    }
    
    function check(pattern, taget, message) {
    	if(pattern.test(taget)) {
        	return true;
        }
        alert(message);
        taget.focus();
        return false;
    }

    
    
    const form = document.signUpForm;

    function emailValCheck(){
    	var emailPattern= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    	var email = form.email.value;
    	if(!check(emailPattern, email, "유효하지 않은 이메일 주소입니다.")) {
    		return false;
    	}
        return true;
    }

    
   
    
	  	//아이디 정규식
		var idJ = /^[a-z0-9]{5,20}$/;
		
  		$("#member_id").focusout(function(){
	     if($('#member_id').val() == ""){
	   		$('#checks').text('아이디를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  		
  		$("#member_id").focusout(function(){
  			if(!idJ.test($(this).val())){
  			$('#checks').text('5~20자의 영문 소문자, 숫자만 사용가능합니다');
  			$('#checks').css('color', 'red');
  		}
  		 });
  		
  		$("#name").focusout(function(){
	     if($('#name').val() == ""){
	   		$('#checks').text('이름을 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
	     
  		$("#email").focusout(function(){
	     if($('#email').val() == ""){
	   		$('#checks').text('이메일을 입력해주세요');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  
  </script>
</html>