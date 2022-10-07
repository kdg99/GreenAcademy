<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>addUser</title>
	</head>
	<body>
		<h3>useBean 액션태그 2</h3>
		<% request.setCharacterEncoding("UTF-8"); %>
		
		<jsp:useBean id="user" class="bean.User2Bean">
		<!-- <jsp:setProperty property="*" name="user"/> -->
			<jsp:setProperty property="name" name="user"/>
			<jsp:setProperty property="age" name="user"/>
			<jsp:setProperty property="hp" name="user"/>
			<jsp:setProperty property="addr" name="user"/>		
		</jsp:useBean>

		<p>
			이름: <%= user.getName() %> <br/>
			나이: <%= user.getAge() %> <br/>
			번호: <%= user.getHp() %> <br/>
			주소: <%= user.getAddr() %> <br/>
		</p>
		
	</body>
</html>