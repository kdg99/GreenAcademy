<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/_header.jsp"/>
<jsp:include page="./_${group}.jsp"/>
<main id="board">
    <section class="view">
        
        <table border="0">
            <caption>글보기</caption>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="${ article.title }" readonly/></td>
            </tr>
            <tr>
                <th>파일</th>
                <td><a href="#">${ article.fname }</a>&nbsp;<span>7</span>회 다운로드</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="content" readonly>${ article.content }</textarea>
                </td>
            </tr>                    
        </table>
        
        <div>
        	
            <a href="/Farmstory2/board/delete.do?group=${group}&cate=${cate}&no=${ article.no }" class="btn btnRemove">삭제</a>
            <a href="/Farmstory2/board/modify.do?group=${group}&cate=${cate}&pg=${ pg }&no=${ article.no }" class="btn btnModify">수정</a>
            <a href="/Farmstory2/board/list.do?group=${group}&cate=${cate}&pg=${ pg }" class="btn btnList">목록</a>
        </div>

        <!-- 댓글목록 -->
        <section class="commentList">
            <h3>댓글목록</h3>                   

            

            
			<c:choose>
           		<c:when test="${ empty comments }">
           			<p class="empty">등록된 댓글이 없습니다.</p>
           		</c:when>
           		<c:otherwise>
           			<c:forEach var="comment" items="${ comments }">                
			            <article>
			                <span class="nick">${ comment.nick }</span>
			                <span class="date">${ comment.rdate }</span>
			                <p class="content">${ comment.content }</p>                        
			                <div>
			                    <a href="/Farmstory2/board/commentDelete.do?${group}&cate=${cate}&pg=${ pg }&no=${ comment.parent }" class="remove">삭제</a>
			                    <a href="#ajax" class="modify">수정</a>
			                </div>
			            </article>
		            </c:forEach>
           		</c:otherwise>
           	</c:choose>
        </section>

        <!-- 댓글쓰기 -->
        <section class="commentForm">
            <h3>댓글쓰기</h3>
            <form action="/Farmstory2/board/commentWrite.do" method="POST">
            	<input type="hidden" name="group" value="${ group }"/>
            	<input type="hidden" name="cate" value="${ cate }"/>
            	<input type="hidden" name="pg" value="${ pg }"/>
            	<input type="hidden" name="parent" value="${ article.no }"/>
            	<input type="hidden" name="uid" value="${ sessUser.uid }"/>
                <textarea name="content" placeholder="댓글내용 입력"></textarea>
                <div>
                    <a href="#" class="btn btnCancel">취소</a>
                    <input type="submit" value="작성완료" class="btn btnComplete"/>
                </div>
            </form>
        </section>

    </section>
</main>
</article>
    </section>
</div>
<jsp:include page="/WEB-INF/_footer.jsp"/>