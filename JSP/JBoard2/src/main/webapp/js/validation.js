/*
 * 
 */
 
//정규식
let regId 	= /^[a-z]+[a-z0-9]{3,15}$/;
let regPass = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/;
//let regName	= /^[가-힣a-zA-Z0-0]{2,5}$/;
let regNick = /^[가-힣A-Za-z0-9]{2,10}$/;
let regHp 	= /^\d{3}-\d{3,4}-\d{4}$/;

// 폼 데이터 검증 결과 상태변수
let isUidOk = false;
let isPassOk = false;
let isNameOk = true;
let isNickOk = false;
let isEmailOk = true;
let isHpOk = false;

//이메일
let isEmailAuthOk = false;
let receivedCode = 0;

$(function(){
	
	//
	$('#btnCheckUid').click(function(){
		isUidOk = false;
		let uid = $('input[name=uid]').val();
		if(!uid.match(regId)){
			$('.uidResult').css('color','red').text('4~16글자의 영어+숫자로 조합해주세요.');
			return;
		}
		$.ajax({
			url: '/JBoard2/user/checkUid.do',
			method: 'GET',
			data: {"uid":uid},
			dataType: 'json',
			success: function(data){
				if(data.result > 0){
					$('.uidResult').css('color','red').text('이미 사용중인 아이디입니다.');
				}else{
					$('.uidResult').css('color','green').text('사용 가능한 아이디입니다.');
					isUidOk = true;
				}
			}
		});
	});
	
	/* 아이디값이 수정됐는지 */
	$('input[name=uid]').keydown(function(){
		isUidOk = false;
	});
	
	//
	$('.checkPass').focusout(function(){
		isPassOk = false;
		let pass1 = $('input[name=pass1]').val();
		let pass2 = $('input[name=pass2]').val();
		
		if(pass1 == pass2){
			if(pass1.match(regPass)){
				$('.passResult').css('color','green').text('비밀번호가 일치합니다.');
				isPassOk = true;
			}else{
				$('.passResult').css('color','red').text('8~20글자의 영어+숫자+특수문자 조합을 사용하세요');
			}
		}else{
			$('.passResult').css('color','red').text('비밀번호가 일치하지 않습니다.');
		}
	});
	
	//
	$('#btnCheckNick').click(function(){
		isNickOk = false;
		let nick = $('input[name=nick]').val();
		if(!nick.match(regNick)){
			$('.nickResult').css('color','red').text('특수문자를 제외한 2~10글자로 지어주세요.');
			return;
		}
		$.ajax({
			url: '/JBoard2/user/checkNick.do',
			method: 'GET',
			data: {"nick":nick},
			dataType: 'json',
			success: function(data){
				if(data.result > 0){
					$('.nickResult').css('color','red').text('이미 사용중인 닉네임입니다.');
				}else{
					$('.nickResult').css('color','green').text('사용 가능한 닉네임입니다.');
					isNickOk = true;
				}
			}
		});
	});
	
	/* 닉네임값이 수정됐는지 */
	$('input[name=uid]').keydown(function(){
		isNickOk = false;
	});
	
	/* 이메일인증 */
	$('#btnEmail').click(function(){
		let email = $('input[name=email]').val();
		
		if(email == ''){
			alert('이메일을 입력해주세요.');
			return;
		}
		
		if(isEmailAuthOk){ 
			return;
		}
		
		$('.emailResult').text('인증코드 전송 중입니다. 잠시만 기다리세요...');
		
		setTimeout(function(){
			$.ajax({
				url: '/JBoard2/user/emailAuth.do',
				method: 'GET',
				data: {"email": email},
				dataType: 'json',
				success: function(data){
					if(data.status > 0){
						//메일전송 성공
						$('.emailResult').text('인증코드를 입력해주세요.');
						$('.auth').show();
						$('input[name=auth]').removeAttr("disabled")
						receivedCode = data.code;
					}else{
						//메일전송 실패
						$('.emailResult').text('다시 시도해주세요');
						alert('메일전송이 실패 했습니다. \n다시 시도 하시기 바랍니다.');
					}
				}
			});
		}, 1000);
	});
		
	//이메일 인증 확인
	$('#btnEmailConfirm').click(function(){
		let code = $('input[name=auth]').val();
		
		if(code == ''){
			alert('이메일 확인 후 코드를 입력해주세요.');
			return;
		}
		
		if(code == receivedCode){
			isEmailAuthOk = true;
			$('input[name=email]').attr('readonly', true);
			$('.emailResult').text('인증완료 되었습니다.');
			$('.auth').hide();
			$('input[name=auth]').hide();
			$('#btnEmailConfirm').hide();
		}
	});
	
	
	//
	$('.checkHp').focusout(function(){
		isHpOk = false;
		let hp = $('input[name=hp]').val();
		if(hp.match(regHp)){
			$('.hpResult').css('color','red').text('');
			isHpOk = true;
		}else{
			$('.hpResult').css('color','red').text('전화번호가 틀렸습니다.');
		}
	});
	
	//
	//폼 전송이 시작될 때 실행되는 폼 이벤트(폼 전송 버튼을 클릭했을 때)
	$('.register > form').submit(function(){
		//폼데이터 유효성 검증(Validation)
		//아이디 검증
		if(!isUidOk){
			alert('아이디를 확인 하십시오.');
			return false;
		}
		//비밀번호 검증
		if(!isPassOk){
			alert('비밀번호를 확인 하십시오.');
			return false;
		}
		//이름 검증
		if(!isNameOk){
			alert('이름을 확인 하십시오.');
			return false;
		}
		//별명 검증
		if(!isNickOk){
			alert('별명을 확인 하십시오.');
			return false;
		}
		//이메일 검증
		if(!isEmailOk){
			alert('이메일을 확인 하십시오.');
			return false;
		}
		//이메일 인증코드 검증
		if(!isEmailAuthOk){
			alert('이메일을 인증 하십시오.');
			return false;
		}
		//휴대폰 검증
		if(!isHpOk){
			alert('휴대폰을 확인 하십시오.');
			return false;
		}
		//최종 전송
		return true;
	});
	
	//아이디 찾기 버튼
	$('.btnNext').click(function(){
		//이메일 인증코드 검증
		if(!isEmailAuthOk){
			alert('이메일을 인증 하십시오.');
			return false;
		}
		let findEmail =  $('input[name=email]').val();
		let findName =  $('input[name=name]').val();
		$.ajax({
			url: '/JBoard2/user/findIdResult.do',
			method: 'POST',
			data: {"email": findEmail, "name": findName},
			dataType: 'json',
			success: function(data){
			}
		});
		return true;
	});
});