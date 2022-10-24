<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/JBoard1/js/validation.js"></script>
<script src="/JBoard1/js/postcode.js"></script>
<script>

</script>
        <main id="user" class="register">
            
            <form action="/JBoard1/user/proc/registerProc.jsp" method="post">
	            <table border="0" class="user">
	                <caption>사이트 이용정보 입력</caption>
	                <tr>
	                    <td>아이디</td>
	                    <td>
	                        <input type="text" name="uId" placeholder="아이디 입력" />
	                        <button type="button" id="btnUidCheck"><a href="#"><img src="/JBoard1/images/chk_id.gif" alt="#"></a></button>
	                    	<span class="resultUid"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>비밀번호</td>
	                    <td>
	                        <input type="password" name="uPass1" placeholder="비밀번호 입력" />
	                        <span class="resultPass"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>비밀번호 확인</td>
	                    <td>
	                        <input type="password" name="uPass2" placeholder="비밀번호 확인 입력" />
	                    </td>
	                </tr>
	            </table>
	            <table border="0" class="privacy">
	                <caption>개인정보 입력</caption>
	                <tr>
	                    <td>이름</td>
	                    <td>
	                        <input type="text" name="uName" placeholder="이름 입력" />
	                        <span class="resultName"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>별명</td>
	                    <td>
	                        <p>공백없이 한글, 영문, 숫자만 입력가능</p>
	                        <input type="text" name="uNick" placeholder="별명 입력" />
	                        <button type="button" id="btnNickCheck"><a href="#"><img src="/JBoard1/images/chk_id.gif" alt="#"></a></button>
	                    	<span class="resultNick"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>E-Mail</td>
	                    <td>
	                        <input type="email" name="uMail" placeholder="이메일 입력" />
	                        <span class="resultMail"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>휴대폰</td>
	                    <td>
	                        <input type="text" name="uHp" placeholder="- 포함 13자리 입력" />
	                        <span class="resultHp"></span>
	                    </td>
	                </tr>
	                <tr>
	                    <td>주소</td>
	                    <td>
	                        <input type="text" name="zip" id="zip" placeholder="우편번호" readonly/>
	                        <button type="button" onclick="postcode()"><a href="#"><img src="/JBoard1/images/chk_post.gif" alt="#"></a></button>
	                        <input type="text" name="uAddr1" id="uAddr1" placeholder="주소를 검색하세요." readonly/>
	                        <input type="text" name="uAddr2" id="uAddr2" placeholder="상세주소를 입력하세요." />
	                    </td>
	                </tr>
	                
	            </table>
	
	            <div>
	                <a href="/JBoard1/user/login.jsp" class="cancel">취소</a>
	                <input type="submit" class="next" value="회원가입"/>
	            </div>

        </form>
        </main>
<%@ include file="./_footer.jsp" %>