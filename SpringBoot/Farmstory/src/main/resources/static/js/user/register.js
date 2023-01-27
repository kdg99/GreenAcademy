/**
 * 
 */
//정규식
let regId 		= /^[a-zA-Z0-9]{4,12}$/; 
let regPass 	= /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,12}$/;
let regName		= /^[가-힣a-zA-Z]{2,18}$/;
let regHp 		= /^0+\d{2}-\d{3,4}-\d{4}$/;
// 폼 데이터 검증 결과 상태변수
let checkUid    = false;
let checkPass   = false;
let checkName   = false;
let checkHp     = false;
let checkEmail  = false;
$(function(){
	
	//ID
	$('#btnUidCheck').click(function(){
		checkUid = false;
		
		let uid = $('input[name=uid]').val();
		
		if(!uid.match(regId)){
			$('#resultUid').css('color','red').text('영문, 숫자로 4~12자까지 설정해주세요.');
			return;
		}
		
		$.ajax({
			url:'/Farmstory/user/checkUid',
			method:'get',
			data:{"uid": uid},
			dataType:'json',
			success:function(data){
				//중복값이 있으면
				if(data.result > 0){
					$('#resultUid').css('color','red').text('이미 사용중인 아이디입니다.');
				}else{
					$('#resultUid').css('color','green').text('사용 가능한 아이디입니다.');
					checkUid = true;
				}
			}
		})//ajax end
	});
	$('input[name=uid]').keydown(function(){
		checkUid = false;
	});
	
	//Password
	$('.checkPass').focusout(function(){
		checkPass = false;
		let pass1 = $('input[name=pass1]').val();
		let pass2 = $('input[name=pass2]').val();
		
		if(pass1 == pass2){
			if(pass1.match(regPass)){
				$('.resultPass').css('color','green').text('비밀번호가 일치합니다.');
				checkPass = true;
			}else{
				$('.resultPass').css('color','red').text('영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해주세요.');
			}
		}else{
			$('.resultPass').css('color','red').text('비밀번호가 일치하지 않습니다.');
		}
	});
	
	//Name
	$('input[name=name]').focusout(function(){
		checkName = false;
		let name = $('input[name=name]').val();
		
		if(name.match(regName)){
			$('.resultName').css('color','green').text('');
			checkName = true;
		}else{
			$('.resultName').css('color','red').text('한글, 영문으로 2~18자까지 입력 가능합니다.');
		}
	});
	$('input[name=name]').keydown(function(){
		checkName = false;
	});
	
	//Hp
	$('input[name=hp]').focusout(function(){
		checkHp = false;
		let hp = $('input[name=hp]').val();
		
		if(hp.match(regHp)){
			$('.resultHp').css('color','green').text('');
			checkHp = true;
		}else{
			$('.resultHp').css('color','red').text('올바른 번호를 사용해주세요.');
		}
	});
	$('input[name=hHp]').keydown(function(){
		checkHp = false;
	});
	
	//email
	$('#btnSendEmail').click(function(){
		let email = $('input[name=email]').val();
		if(email == ''){
			$('.emailResult').text('이메일을 입력해주세요');
			return;
		}
		
		$('.emailResult').text('인증코드 전송 중입니다. 잠시만 기다리세요...');
		
		$.ajax({
			url: '/Farmstory/user/emailAuth',
			method: 'GET',
			data: {"email": email},
			dataType: 'json',
			success: function(data){
				if(data.status > 0){
					//메일전송 성공
					$('.auth').show();
					$('.emailResult').text('인증코드를 입력해주세요.');
					receivedCode = data.code;
				}else{
					//메일전송 실패
					$('.emailResult').css('color','red').text('메일 전송에 실패했습니다. 다시 시도해주세요');
				}
			}
		});
	});
	
	//email code check
	$('#btnEmailConfirm').click(function(){
		let code = $('input[name=code]').val();
		if(code == ''){
			alert('이메일 확인 후 코드를 입력해주세요.');
			return;
		}

		if(code == receivedCode){
			$('.auth').hide();
			$('input[name=email]').attr('readonly', true);
			$('.emailResult').css('color','green').text('인증완료 되었습니다.');
			checkEmail = true;
		}
	});
	
	/*****************
		최종 입력 확인
	****************/	
	$('.register > form').submit(function(){
		//폼데이터 유효성 검증(Validation)
		//아이디 검증
		if(!checkUid){
			alert('아이디를 확인 하십시오.');
			return false;
		}
		//비밀번호 검증
		if(!checkPass){
			alert('비밀번호를 확인 하십시오.');
			return false;
		}
		//이름 검증
		if(!checkName){
			alert('이름을 확인 하십시오.');
			return false;
		}
		//이메일 검증
		if(!checkEmail){
			alert('이메일을 확인 하십시오.');
			return false;
		}
		//휴대폰 검증
		if(!checkHp){
			alert('휴대폰을 확인 하십시오.');
			return false;
		}
		//최종 전송
		return true;
	});
		
});