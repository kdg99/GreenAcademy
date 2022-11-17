<%@page import="java.util.List"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@page import="kr.co.farmstory1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	pageContext.include("./_"+group+".jsp");
	
	ArticleDAO dao = ArticleDAO.getInstance();
	
	//페이지 처리
	String pg = request.getParameter("pg");
	int start = 0; //글목록 불러올 때 쓰임
	int total = 0; //총 글 수
	int currentPage = 1;
	int currentPageGroup = 1; //Group 3개로 for문 돌려서 페이지그룹 10개 단위로 보기 가능
	int pageGroupStart;
	int pageGroupEnd;
	int articleNum; //글번호
	int amount = 10; // 한 페이지에 몇 개 보여줄지
	
	if (pg != null){
		currentPage = Integer.parseInt(pg);
		start = (currentPage - 1) * 10;
	}
	currentPageGroup = (int) Math.ceil(currentPage / 10.0);
	pageGroupStart = (currentPageGroup - 1) * 10 + 1;
	pageGroupEnd = currentPageGroup * 10;
	
	//전체 게시물 개수
	total = dao.selectCountTotal(cate);
	articleNum = total - start;
	
	//마지막 페이지 번호
	int lastPageNum;
	if(total % 10 == 0){
		lastPageNum = total / 10;
	}else{
		lastPageNum = total / 10 + 1;
	}
	if (pageGroupEnd > lastPageNum){
		pageGroupEnd = lastPageNum;
	}
	//글 목록 가져오기
	List<ArticleBean> articles = dao.selectArticles(cate, start, amount);	
	
	
%>
<main id="board" class="list">
    
    <table border="0">
        <caption>글목록</caption>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>날짜</th>
            <th>조회</th>
        </tr>
        
        <% for(ArticleBean article : articles) {%>
        <tr>
            <td><%= articleNum-- %></td>
            <td><a href="/Farmstory1/board/view.jsp?group=<%= group %>&cate=<%= cate %>&no=<%= article.getNo() %>&pg=<%= currentPage %>"><%= article.getTitle() %></a></td>
            <td><%= article.getNick() %></td>
            <td><%= article.getRdate() %></td>
            <td><%= article.getHit() %></td>
        </tr>               
        <% } %>
        
    </table>

    <div class="page">
        <% if (pageGroupStart > 1) { %>
        	<a href="/Farmstory1/board/list.jsp?pg=<%= pageGroupStart - 1 %>" class="prev">이전</a>
        <% } %>
        <% for (int num = pageGroupStart ; num <= pageGroupEnd ; num++){ %>
        	<a href="/Farmstory1/board/list.jsp?pg=<%= num %>&group=<%= group %>&cate=<%= cate %>" class="num <%= num == currentPage ? "current" : "off"%>"><%= num %></a>
        <% } %>
        <% if(pageGroupEnd < lastPageNum){ %>
        	<a href="/Farmstory1/board/list.jsp?pg=<%= pageGroupEnd + 1 %>" class="next">다음</a>
       	<% } %>
    </div>

    <a href="/Farmstory1/board/write.jsp?group=<%= group %>&cate=<%= cate %>" class="btnWrite">글쓰기</a>

</main>
<%@ include file="../_footer.jsp" %>