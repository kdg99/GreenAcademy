<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BookStore::Modify</title>
	</head>
	<body>
		<h3>도서수정</h3>
		<a href="/Bookstore2/index.jsp">처음으로</a>
		<a href="/Bookstore2/book/list.do">도서목록</a>

		<form action="/Bookstore2/book/modify.do" method="post">
			<table border="1" class="bookModify">
				<tr>
					<td>도서번호</td>
					<td> <input type="text" name="bookId" readonly value="${book.getBookId()}"/></td>
				</tr>
				<tr>
					<td>도서명</td>
					<td> <input type="text" name="bookName" value="${book.getBookName()}"/></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td> <input type="text" name="publisher" value="${book.getPublisher()}"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price" value="${book.getPrice()}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정"/>
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>