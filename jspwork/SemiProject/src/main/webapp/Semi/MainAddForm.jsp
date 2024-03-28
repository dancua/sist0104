<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	$(function() {
		//아이디 중복체크
		$("#btnIdCheck").click(function() {

			var id = $("#id").val();

			$.ajax({
				type : "get",
				url : "idCheck.jsp",
				dataType : "json",
				data : {"id" : id},
				success : function(res) {
					if (res.count == 1) {
						alert("이미 가입된 아이디입니다.\n");
						$("span.idsuccess").text("not ok!!");
					} else {
						alert("사용 가능한 아이디입니다.");
						$("span.idsuccess").text("ok!!");
					}
				}
			});
		});
		
		$("#selemail").change(function() {
			var email = $(this).val();
			if (email != "-") {
				$("#email2").val(email);
			} else {
				$("#email2").val("");
			}
		});
	})
	
	function validateForm(){
		var id= document.getElementById('id').value;
		var pass = document.getElementById('pass').value;
		
	}
	
	/* function check(f) {
		if (f.pass.value != f.pass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			//초기화
			f.pass.value = "";
			f.pass2.value = "";
			return false; //action 호출하지 않음.
		}
	} */
	function sample6_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수

	            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }

	            // 참고항목 조합
	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraAddr += data.bname;
	            }
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 주소와 참고항목을 합쳐서 최종 주소로 설정
	            var fullAddress = addr + (extraAddr !== '' ? ' ' + extraAddr :'');

	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('postcode').value = data.zonecode;
	            document.getElementById("addr").value = fullAddress;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("addrDetail").focus();
	        }
	    }).open();
	}
	
	function validateForm() {
	    var id = document.getElementById('id').value;
	    var pass = document.getElementById('pass').value;
	    var email1 = document.getElementsByName('email1')[0].value;
	    var email2 = document.getElementsByName('email2')[0].value;
	    var birthday = document.getElementById('birthday').value;

	    // 아이디 유효성 검사: 4자 이상 8자 이하
	    if (id.length < 4 || id.length > 16) {
	        alert("아이디는 4자 이상 16자 이하여야 합니다.");
	        return false;
	    }

	    // 비밀번호 유효성 검사: 6자 이상
	    if (pass.length < 6) {
	        alert("비밀번호는 6자 이상이어야 합니다.");
	        return false;
	    }

	    // 이메일 유효성 검사: '@' 포함 여부
	    if (email1.length === 0 || email2.length === 0 || email2.indexOf('@') === -1) {
	        alert("올바른 이메일을 입력해주세요.");
	        return false;
	    }

	    // 생년월일 유효성 검사: 8자리 숫자 형식
	    if (!/^\d{8}$/.test(birthday)) {
	        alert("생년월일은 8자리 숫자로 입력해주세요.");
	        return false;
	    }
	    
	    if (f.pass.value != f.pass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			//초기화
			f.pass.value = "";
			f.pass2.value = "";
			return false; //action 호출하지 않음.
		}

	    return true;
	}
	
</script>
</head>
<body>
	<div style="margin: 100px 100px; width: 500px;">
		<form action="" method="post" onsubmit="return validateForm(this)">
			<table class="table table-bordered" style="width: 500px;">
				<caption align="top">
					<b>회원가입</b>
				</caption>
				<tr>
					<th width="100" class="table-success">아이디</th>
					<td>
						<div class="d-inline-flex">
							<input type="text" name="id" id="id" maxlength="8"
								required="required" style="width: 120px;">
							<button type="button" class="btn btn-danger" id="btnIdCheck"
								style="margin-left: 10px;">중복체크</button>
							<span class="idsuccess"></span>
						</div>
					</td>
				</tr>
				
				<tr>
					<th width="100" class="table-success">비밀번호</th>
					<td>
						<div class="d-inline-flex">
							<input type="password" name="pass" class="form-control"
								required="required" style="width: 130px;" placeholder="비밀번호">
							<input type="password" name="pass2" class="form-control"
								required="required" style="width: 130px; margin-left: 5px;"
								placeholder="비밀번호 확인">
						</div>
					</td>
				</tr>

				<tr>
					<th width="100" class="table-success">이름</th>
					<td><input type="text" name="name" class="form-control"
						required="required" style="width: 120px;"></td>
				</tr>

				<tr>
					<th width="100" class="table-success">핸드폰</th>
					<td><input type="text" name="hp" class="form-control"
						required="required" style="width: 120px;"></td>
				</tr>

				<tr>
					<th width="100" class="table-success">주소</th>
					<td><input type="text" id="postcode" placeholder="우편번호" style="width:80px;">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" id="addr" placeholder="주소" style="width:350px;"><br>
						<input type="text" id="addrDetail" placeholder="상세주소" style="width:350px;"></td>
				</tr>

				<tr>
					<th width="100" class="table-success">이메일</th>
					<td>
						<div class="d-inline-flex">
						
							<input type="text" name="email1" class="form-control"
								required="required" style="width: 80px;"> <b
								style="margin-left: 10px;">@</b> <input type="text"
								name="email2" id="email2" class="form-control"
								required="required" style="width: 120px; margin-left: 10px;">
								
								
							<select id="selemail" class="form-control"
								style="margin-left: 10px;">
								<option value="-">직접입력</option>
								<option value="naver.com">네이버</option>
								<option value="nate.com">네이트</option>
								<option value="gmail.com">구글</option>
								<option value="daum.net">다음</option>
							</select>
						</div>
						
					</td>
				</tr>
				
			
				<tr>
    				<th width="100" class="table-success">생년월일</th>
    			<td>
       				 <input type="text" id = "birthday" class="form-control" required="required"
       				 	 style="width: 150px;" placeholder="ex)20050405">
    			</td>
				</tr>
				
				<tr>
					<th width="100" class="table-success">성별</th>
					<td>
						<div class="d-inline-flex">
							<select id="gender" class="form-control"
								style="margin-left: 10px;">
								<option value="남자">남자</option>
								<option value="여자">여자</option>
								

							</select>
						</div>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-info"
							style="width: 100px;">가입하기</button>
					</td>
					<div class="links">
					 <a href="#">아이디 찾기</a> | <a href="#">로그인</a> | <a href="#">회원가입</a>
				</div>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>
