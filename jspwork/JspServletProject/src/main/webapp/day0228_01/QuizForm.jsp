<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script href="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
			<form action="QuizWrite.jsp" method = "post">
				<table class="table table-bordered" style="width:400px;">
					<tr>
					<th width="100" class=table-info>사원명</th>
					<td>
					<input type="text" name="name" placeholder="이름" required="required" class="form-control"
					style="width:120px">
					</td>
				</tr>
				<tr>
					<th width="100" class=table-info>입사일자</th>
					<td>
					<input type="date" name="date" style="width:150px">
					</td>
				</tr>
				<tr>
				<th>오늘 선택 점심메뉴</th>
				<td>
				<input type="radio" name="Food" value="../image/Food/10.jpg">
					<img alt="" src="../image/Food/10.jpg" style="width:70px;"/>
				<input type="radio" name="Food" value="../image/Food/12.jpg">
					<img alt="" src="../image/Food/12.jpg" style="width:70px;"/>
				<input type="radio" name="Food" value="../image/Food/3.jpg">
					<img alt="" src="../image/Food/3.jpg" style="width:70px;"/>
				</td>
			</tr>
				<tr>
				<th>건의하는 메뉴</th>
				<td><select name="Food2" class="form-control"
					style="width: 100px;" multiple="multiple">
						<option value="쌀국수">쌀국수</option>
						<option value="마라탕">마라탕</option>
						<option value="돈까스">돈까스</option>
						<option value="우동">우동</option>
						<option value="소바">소바</option>
				</select></td>
			</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" class="btn btn-success" value="전송" style="width:80px">
					<input type="reset" class="btn btn-warning" value="초기화" style="width:80px">
					</td>
				</tr>
			</table>
		</form>

</body>
</html>