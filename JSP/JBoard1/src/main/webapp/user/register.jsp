<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script>

	//정규표현식
	var regPass2 = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{5,}$/;
	var regPass = /^(?!((?:[A-Za-z]+)|(?:[~!@#$%^&*()_+=]+)|(?:[0-9]+))$)[A-Za-z\d~!@#$%^&*()_+=]{5,15}$/;
	var regHp = /^\d{3}-\d{3,4}-\d{4}$/;
	var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	// 폼 데이터 검증 결과 상태변수
	let isUidOk = false;
	let isPassOk = false;
	let isNameOk = false;
	let isNickOk = false;
	let isEmailOk = false;
	let isHpOk = false;

	$(function(){
		
		//비밀번호 일치여부 확인
		$('input[name=uPass2]').focusout(function(){
			let uPass1 = $('input[name=uPass1]').val();
			let uPass2 = $(this).val();
			
			if(uPass1 == uPass2){
				
				
				if(regPass2.test(uPass2)){
					isPassOk = true;
					$('.resultPass').css('color','green').text('비밀번호가 일치합니다.');
				}else{
					$('.resultPass').css('color','red').text('비밀번호는 영문/숫자/특수문자의 5~15자리 조합이어야 합니다.');
				}
				
			}else{
				isPassOk = false;
				$('.resultPass').css('color','red').text('비밀번호가 일치하지 않습니다.');
			}
			
		});
		
		
		//폼 전송이 시작될 때 실행되는 폼 이벤트(폼 전송 버튼을 클릭했을 때)
		$('.register > form').submit(function(){
			//폼데이터 유효성 검증(Validation)
			//아이디 검증
			
			//비밀번호 검증
			
			//이름 검증
			
			//별명 검증
			
			//이메일 검증
			
			//휴대폰 검증
			
			return false;
		});
	});	
	
</script>
        <main id="user" class="register">
            
            <form action="/JBoard1/user/proc/registerProc.jsp" method="post">
            <table border="0" class="user">
                <caption>사이트 이용정보 입력</caption>
                <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" name="uId" placeholder="아이디 입력" />
                        <button type="button"><a href="#"><img src="/JBoard1/images/chk_id.gif" alt="#"></a></button>
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
                        <input type="text" name="uPh" placeholder="- 포함 13자리 입력" />
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