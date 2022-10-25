<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String success = request.getParameter("success");
%>
<%@ include file="./_header.jsp" %>

<script>
	
	//로그인처리
	let success = "<%= success%>";
	if(success == '100'){
		//일치X
		alert('일치하는 회원이 없습니다.\n아이디, 비밀번호를 확인해주세요.');
	}else if (success == '101'){
		//비정상 접근
		alert('비정상적인 접근이 감지되었습니다.');
	}else if (success == '201'){
		//로그아웃
		alert('로그아웃 되었습니다.');
	}
</script>

        <main id="user" class="login">
            <form action="/JBoard1/user/proc/loginProc.jsp">
                <table border="0">
                    <tr>
                        <td><img src="/JBoard1/images/login_ico_id.png" alt="로그인"/></td>
                        <td><input type="text" name="uid"/></td>
                    </tr>
                    <tr>
                        <td><img src="/JBoard1/images/login_ico_pw.png" alt="비밀번호"/></td>
                        <td><input type="password" name="pass" placeholder="비밀번호 입력"/></td>
                    </tr>
                </table>
                <input type="submit" class="btnLogin" value="로그인"/>
            </form>

            <div class="info">
                <h3>회원로그인 안내</h3>
                <p>아직 회원이 아니시면 회원으로 가입하세요.</p>
                <a href="/JBoard1/user/terms.jsp">회원가입</a>
            </div>

        </main>
<%@ include file="./_footer.jsp" %>