<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
  <main>
    <img
         class="logo"
         src="./images/codestates-logo1.png"
         alt="CODE_STATES_LOGO"
         />

    <fieldset>
      <input type="text" id="username" placeholder="아이디" />
    </fieldset>

    <div class="success-message hide">사용할 수 있는 아이디입니다</div>
    <div class="failure-message hide">아이디는 4~12글자이어야 합니다</div>
    <div class="failure-message2 hide">영어 또는 숫자만 가능합니다</div>

    <fieldset>
      <input type="password" id="password" placeholder="비밀번호" />
    </fieldset>

    <div class="strongPassword-message hide">8글자 이상, 영문, 숫자, 특수문자(@$!%*#?&)를 사용하세요</div>

    <fieldset>
      <input
             type="password"
             id="password-retype"
             placeholder="비밀번호 확인"
             />
    </fieldset>

    <div class="mismatch-message hide">비밀번호가 일치하지 않습니다</div>

    <fieldset class="signup">
      <button>회원가입</button>
    </fieldset>

    <script src="script2.js">
 	// 1. 아이디 입력창 정보 가져오기
    let elInputUsername = document.querySelector('#username'); // input#username
    // 2. 성공 메시지 정보 가져오기
    let elSuccessMessage = document.querySelector('.success-message'); // div.success-message.hide
    // 3. 실패 메시지 정보 가져오기 (글자수 제한 4~12글자)
    let elFailureMessage = document.querySelector('.failure-message'); // div.failure-message.hide
    // 4. 실패 메시지2 정보 가져오기 (영어 또는 숫자)
    let elFailureMessageTwo = document.querySelector('.failure-message2'); // div.failure-message2.hide
    
    
 	// 1. 비밀번호 입력창 정보 가져오기
    let elInputPassword = document.querySelector('#password'); // input#password
    // 2. 비밀번호 확인 입력창 정보 가져오기
    let elInputPasswordRetype = document.querySelector('#password-retype'); // input#password-retype
    // 3. 실패 메시지 정보 가져오기 (비밀번호 불일치)
    let elMismatchMessage = document.querySelector('.mismatch-message'); // div.mismatch-message.hide
    // 4. 실패 메시지 정보 가져오기 (8글자 이상, 영문, 숫자, 특수문자 미사용)
    let elStrongPasswordMessage = document.querySelector('.strongPassword-message'); // div.strongPassword-message.hide
    
    function idLength(value) {
    	  return value.length >= 4 && value.length <= 12
    	}
    
    function onlyNumberAndEnglish(str) {
    	  return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
    	}
    
    function strongPassword (str) {
    	  return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(str);
    	}
    
    function isMatch (password1, password2) {
    	  return password1 === password2;
    	}
    </script>
  </main>
</body>
</html>