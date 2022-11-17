<%@page import="java.util.List"%>
<%@page import="kr.co.farmstory1.dao.ArticleDAO"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../user/_loginCheck.jsp" %>
<%
	String no = request.getParameter("no");
	String pg = request.getParameter("pg");
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	ArticleDAO dao = ArticleDAO.getInstance();
	
	ArticleBean article = dao.selectArticle(no);
	dao.updateArticleHit(no);
	List<ArticleBean> comments = dao.selectComments(no);
	
	// cate, group 받아오기 
	// 번호, 페이지 받아오기 >> 목록버튼 수정
	// 댓글 부분 링크 수정
	
%>
<main id="board" class="view">
    <table>
        <caption>글보기</caption>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title" value="<%= article.getTitle() %>" readonly/></td>
        </tr>
        <% if(article.getFile() > 0) { %>
        <tr>
            <th>파일</th>
            <td><a href="/Farmstory1/board/proc/download.jsp?fno=<%= article.getFno() %>"><%= article.getOriName() %></a><span> <%= article.getDownload() %></span>회 다운로드</td>
        </tr>
        <% } %>
        <tr>
            <th>내용</th>
            <td><textarea name="content" readonly> <%= article.getContent() %> </textarea></td>
        </tr>
    </table>
    <div>
    	<% if(sessUser == null) {
    		} else if(sessUser.getUid().equals(article.getUid())) { %>
        <a href="/Farmstory1/board/proc/deleteProc.jsp?group=<%= group %>&cate=<%= cate %>&no=<%= no %>" class="btn btnRemove">삭제</a>
        <a href="/Farmstory1/board/modify.jsp?group=<%= group %>&cate=<%= cate %>&no=<%= no %>&pg=<%= pg %>" class="btn btnModify">수정</a>
        <% } %>
        <a href="/Farmstory1/board/list.jsp?group=<%= group %>&cate=<%= cate %>&pg=<%= pg %>" class="btn btnList">목록</a>
    </div>

    <!--댓글목록-->
    <section class="commentList">
        <h3>댓글목록</h3>
        <% for(ArticleBean comment : comments){ %>
        	<article>
            <span class="nick"><%= comment.getNick() %></span>
            <span class="date"><%= comment.getRdate() %></span>
            <p class="content"><%= comment.getContent() %></p>
            
            <% if (sessUser == null) {}
               else if(sessUser.getUid().equals(comment.getUid())) { %>
            <div>
                <a href="#" class="remove" data-no="<%=comment.getNo()%>">삭제</a>
                <a href="#" class="modify" data-no="<%=comment.getNo()%>">수정</a>
            </div>
            <% } %>
            
        </article>
        <% } %>
        <% if(comments.size() == 0) { %>
        <p class="empty">등록된 댓글이 없습니다.</p>
        <% } %>
    </section>

    <!--댓글쓰기-->
    <section class="commentForm">
        <h3>댓글쓰기</h3>
        <form action="#" method="post">
        	<%if (sessUser != null) { %>
        	<input type="hidden" name="parent" value="<%= no %>" />
        	<input type="hidden" name="uid" value="<%= sessUser.getUid() %>" />
        	<input type="hidden" name="pg" value="<%= pg %>" />
        	<% } %>
            <textarea name="content" placeholder="댓글내용 입력"></textarea>
            <div>
                <a href="#" class="btn btnCancel">취소</a>
                <input type="submit" class="btn btnComplete" value="작성완료"/>
            </div>
        </form>
    </section>
</main>
<%@ include file="../_footer.jsp" %>