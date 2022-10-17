<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
        <main id="user" class="register">
            
            <form action="" method="get">
            <table border="0" class="user">
                <caption>사이트 이용정보 입력</caption>
                <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" name="uID" placeholder="아이디 입력" />
                        <button type="button"><a href="#"><img src="/JBoard1/images/chk_id.gif" alt="#"></a></button>
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" name="uPW" placeholder="비밀번호 입력" />
                    </td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td>
                        <input type="password" name="uPW" placeholder="비밀번호 확인 입력" />
                    </td>
                </tr>
            </table>
            <table border="0" class="privacy">
                <caption>개인정보 입력</caption>
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" name="uName" placeholder="이름 입력" />
                    </td>
                </tr>
                <tr>
                    <td>별명</td>
                    <td>
                        <p>공백없이 한글, 영문, 숫자만 입력가능</p>
                        <input type="text" name="uNick" placeholder="별명 입력" />
                    </td>
                </tr>
                <tr>
                    <td>E-Mail</td>
                    <td>
                        <input type="text" name="uMail" placeholder="이메일 입력" />
                    </td>
                </tr>
                <tr>
                    <td>휴대폰</td>
                    <td>
                        <input type="text" name="uPH" placeholder="- 포함 13자리 입력" />
                    </td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>
                        <input type="text" name="uAddrNum" placeholder="우편번호" readonly/>
                        <button type="button"><a href="#"><img src="/JBoard1/images/chk_post.gif" alt="#"></a></button>
                        <input type="text" name="uAddr" placeholder="주소를 검색하세요." readonly/>
                        <input type="text" name="uAddr" placeholder="상세주소를 입력하세요." />
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