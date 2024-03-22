<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
#mainimg {
	width: 100px;
	heigjt: 100px;
	border-radius: 100px;
	margin-top: 30px;
	margin-left: 20px;
	border: 1px solid tomato;
}
</style>
<script type="text/javascript">
	function delfunc(num) {
		// alert(num);
		$("#delnum").val(num);
		$("#myModal").modal('show');

		//삭제버튼이벤트
		$("button.btndel").click(
				function() {
					var num = $("#delnum").val();
					var pass = $("#delpass").val();

					// alert(num+","+pass);
					//삭제파일 호출

					location.href = "member/deletemypage.jsp?num=" + num
							+ "&pass=" + pass;

				})
	}
	function upfunc(num) {
	//	alert(num);
	$("#upfunc").val(num);
	$("#myModal2").modal('show');
	
		$("button.btnupdate").click(
		function(){
			var num = $("#upnum").val();
			var pass = $("#uppass").val();
			
			alert(num+","+pass);
			
			location.href = "member/updatForm.jsp?num="+num + "&pass="+pass;
		})
	}
	
</script>
</head>
<body>
	<%
	MemberDao dao = new MemberDao();
	List<MemberDto> list = dao.getAllDatas();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	String loginok = (String) session.getAttribute("loginok");
	String myid = (String) session.getAttribute("myid");
	%>
	<div style="margin: 100px 200px; width: 800px;">
		<table class="table table-bordered">
			<%
			for (MemberDto dto : list) {
				if(loginok!=null && myid.equals(dto.getId())){
			%>
			<tr>
				<td rowspan="6" align="center"><img src="image2/avata/b4.png"
					id="mainimg"></td>
				<td style="width: 300px;">회원명: <%=dto.getName()%></td>
				<td rowspan="6" style="width: 120px;" align="center" valign="middle">
					<button type="button" class="btn btn-outline-info"
					onclick="location.href='index.jsp?main=member/updatepassForm.jsp?num=<%=dto.getNum()%>'">수정</button> <br>
					<br>
					<button type="button" class="btn btn-outline-danger"
						onclick="delfunc('<%=dto.getNum()%>')">탈퇴</button> <br>
				<br>
				</td>
			</tr>

			<tr>
				<td>아이디:<%=dto.getId()%></td>
			</tr>

			<tr>
				<td>이메일:<%=dto.getEmail()%></td>
			</tr>

			<tr>
				<td>핸드폰:<%=dto.getHp()%></td>
			</tr>

			<tr>
				<td>주소:<%=dto.getAddr()%></td>
			</tr>

			<tr>
				<td>가입일:<%=sdf.format(dto.getGaipday())%></td>
			</tr>
			<%
			}
			%>
			<%} %>
		</table>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">삭제확인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body d-inline-flex">
					<input type="hidden" id="delnum"> <b>삭제 비밀번호:</b> <input
						type="password" id="delpass" class="form-control"
						style="width: 120px; margin-left: 10px;">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger btndel"
						data-bs-dismiss="modal">삭제</button>
				</div>
			</div>
		</div>
	</div>
	
		<!-- The Modal -->
	<div class="modal fade" id="myModal2">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">수정비밀번호확인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body d-inline-flex">
					<input type="hidden" id="upnum"> <b>수정확인 비밀번호:</b> <input
						type="password" id="uppass" class="form-control"
						style="width: 120px; margin-left: 10px;">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger btnupdate"
						data-bs-dismiss="modal">수정</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>