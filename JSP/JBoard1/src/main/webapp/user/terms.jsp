<%@page import="kr.co.jboard1.config.Sql"%>
<%@page import="kr.co.jboard1.bean.TermsBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.jboard1.config.DBCP"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<%
String terms = null;
	String privacy = null;
	TermsBean tb = null;
	try{
		Connection conn = DBCP.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
		
		if(rs.next()){
	tb = new TermsBean();
	tb.setTerms(rs.getString(1));
	tb.setPrivacy(rs.getString(2));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<script>
	$(function(){
		
		$('.next').click(function(){
			
			let isCheck1 = $('input[class=terms]').is(':checked');
			let isCheck2 = $('input[class=privacy]').is(':checked');
			
			if(isCheck1 && isCheck2){
				return true;
			}else{
				alert('약관에 동의하셔야 진행 가능합니다.');
				return false;	
			}
		});
		
	});
</script>

<main id="user" class="terms">
    <table border="0">
        <caption>사이트 이용약관</caption>
        <tr>
            <td>
                <textarea class="terms" readonly><%= tb.getTerms() %></textarea>
                <label><input type="checkbox" class="terms">&nbsp;동의합니다.</label>
            </td>
        </tr>
    </table>

    <table border="0">
        <caption>개인정보 취급방침</caption>
        <tr>
            <td>
                <textarea class="privacy" readonly><%= tb.getPrivacy() %></textarea>
                <label><input type="checkbox" class="privacy">&nbsp;동의합니다.</label>
            </td>
        </tr>
    </table>

    <p>
        <a href="/JBoard1/user/login.jsp" class="cancel">취소</a>
        <a href="/JBoard1/user/register.jsp" class="next">다음</a>
    </p>
</main>
<%@ include file="./_footer.jsp" %>