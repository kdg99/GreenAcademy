<%@page import="kr.co.farmstory1.dao.ArticleDAO"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	String pg = request.getParameter("pg");
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	
	ArticleBean article = ArticleDAO.getInstance().selectArticle(no);
	
%>
<main id="board" class="modify">
    <form action="/Farmstory1/board/proc/modifyProc.jsp" method="POST">
    	<input type="hidden" name="no" value="<%= no %>" />
    	<input type="hidden" name="pg" value="<%= pg %>" />
    	<input type="hidden" name="group" value="<%= group %>" />
    	<input type="hidden" name="cate" value="<%= cate %>" />
        <table border="0">
            <caption>글수정</caption>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" placeholder="제목을 입력하세요." value="<%=article.getTitle() %>"/></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="content"><%=article.getContent() %></textarea></td>
            </tr>
            <tr>
                <th>첨부</th>
                <td><input type="file" name="file"/></td>
            </tr>

        </table>
        <div>
            <a href="/JBoard1/view.jsp" class="btn btnCancel">취소</a>
            <input type="submit" class="btn btnComplete" value="수정완료"/>
        </div>
    </form>
</main>
<%@ include file="../_footer.jsp" %>