/**
 * 날짜 : 2022/10/24
 * 이름 : 김동근
 * 내용 : 회원가입 입력데이터 유효성 검증
 */

 
//정규표현식
let regPass2	= /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{5,}$/;
let regPass 	= /^(?!((?:[A-Za-z]+)|(?:[~!@#$%^&*()_+=]+)|(?:[0-9]+))$)[A-Za-z\d~!@#$%^&*()_+=]{5,15}$/;
let regHp 		= /^\d{3}-\d{3,4}-\d{4}$/;
let regEmail 	= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
let regId 		= /^[a-z]+[a-z0-9]{4,19}$/g;
let regName		= /^[가-힣a-zA-Z0-0]{2,5}$/;

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
		
		if(uPass1 == uPass2){ //비밀번호와 확인비밀번호가 같으면
			
			if(uPass2.match(regPass2)){ // 비밀번호가 정규표현식과 일치하면
				isPassOk = true;
				$('.resultPass').css('color','green').text('비밀번호가 일치합니다.');
			}else{
				isPassOk = false;
				$('.resultPass').css('color','red').text('비밀번호는 영문/숫자/특수문자의 5~15자리 조합이어야 합니다.');
			}
			
		}else{
			isPassOk = false;
			$('.resultPass').css('color','red').text('비밀번호가 일치하지 않습니다.');
		}
		
	});
	
	//아이디 유효성 검증 및 중복 체크
	
	//아이디값이 수정됐는지
	$('input[name=uId]').keydown(function(){
		isUidOk = false;
	});
	
	//확인버튼
	$('#btnUidCheck').click(function(){
		let uid = $('input[name=uId]').val();
		
		//이미 확인했으면 바로 종료 << 수정됐는지 확인 >> 수정 됐으면 false로 바꿀 것
		if(isUidOk){
			return;
		}
		
		//정규표현식 확인
		if(!uid.match(regId)){
			isUidOk = false;
			$('.resultUid').css('color','red').text('아이디가 유효하지 않습니다.');
			return;
		}
		
		//중복확인
		let jsonData = {"uid":uid};
		$('.resultUid').text('...');
		setTimeout(()=>{
			$.ajax({
				url:'./proc/checkUid.jsp',
				method:'get',
				data:jsonData,
				dataType:'json',
				success:function(data){
					if(data.result == 0){
						isUidOk = true;
						$('.resultUid').css('color','green').text('사용 가능한 아이디 입니다.');
					}else{
						isUidOk= false;
						$('.resultUid').css('color','red').text('이미 사용중인 아이디 입니다.');
					}
				}
			});
		},500);
		
		
	});
	
	//이름 유효성 검증
	$('input[name=uName]').focusout(function(){
		let name = $(this).val();
		
		if(!name.match(regName)){
			isNameOk = false;
			$('.resultName').css('color','red').text('이름은 한글 2자 이상 이어야 합니다.');
		}else{
			isNameOk = true;
			$('.resultName').text('');
		}
	});
	
	//별명 유효성 검증
	//별명값이 수정됐는지
	$('input[name=uNick]').keydown(function(){
		isNickOk = false;
	});
	
	//확인버튼
	$('#btnNickCheck').click(function(){
		let nick = $('input[name=uNick]').val();
		
		//이미 확인했으면 바로 종료 << 수정됐는지 확인 >> 수정 됐으면 false로 바꿀 것
		if(isNickOk){
			return;
		}
		
		//정규표현식 확인
		if(!nick.match(regId)){
			isNickOk = false;
			$('.resultNick').css('color','red').text('닉네임이 유효하지 않습니다.');
			return;
		}
		
		//중복확인
		let jsonData = {"nick":nick};
		$('.resultNick').text('...');
		setTimeout(()=>{
			$.ajax({
				url:'./proc/checkNick.jsp',
				method:'get',
				data:jsonData,
				dataType:'json',
				success:function(data){
					if(data.result == 0){
						isNickOk= true;
						$('.resultNick').css('color','green').text('사용 가능한 닉네임 입니다.');
					}else{
						isNickOk= false;
						$('.resultNick').css('color','red').text('이미 사용중인 닉네임 입니다.');
					}
				}
			});
		},500);
	});
	
	//이메일 유효성 검증
	$('input[name=uMail]').focusout(function(){
		let email = $(this).val();
		if(!email.match(regEmail)){
			isEmailOk= false;
			$('.resultMail').css('color','red').text('이메일이 유효하지 않습니다.');
		}else{
			isEmailOk= true;
			$('.resultMail').text('');
		}
	});
	
	//휴대폰 유효성 검증
	$('input[name=uHp]').focusout(function(){
		let hp = $(this).val();
		if(!hp.match(regHp)){
			isHpOk= false;
			$('.resultHp').css('color','red').text('휴대폰 번호가 유효하지 않습니다.');
		}else{
			isHpOk= true;
			$('.resultHp').text('');
		}
	});
	
	
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
		//휴대폰 검증
		if(!isHpOk){
			alert('휴대폰을 확인 하십시오.');
			return false;
		}
		//최종 전송
		console.log('이게나오면안댐');
		return true;
	});
});	
