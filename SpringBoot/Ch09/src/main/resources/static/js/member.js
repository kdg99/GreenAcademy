/**
 * 
 */

 		
$(document).ready(function(){
	//member 목록 요청
	$('.memberList').click(function(){
		$.ajax({
			url		: '/Ch09/member',
			method	: 'GET',
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//member 조회 요청
	$('.memberSelect').click(function(){
		$.ajax({
			url		: '/Ch09/member/r101',
			method	: 'GET',
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//member 등록 요청
	$('.memberRegister').click(function(){
		let jsonData = {
				"uid"	: "r101",
				"name"	: "홍길동",
				"hp" 	: "010-1234-1235",
				"pos" 	: "신입",
				"dep" 	: 5,
				"rdate"	: "2023-01-16"
			}
		
		$.ajax({
			url		: '/Ch09/member',
			method	: 'POST',
			data	: jsonData,
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//member 수정 요청
	$('.memberModify').click(function(){
		let jsonData = {
				"uid": "r101",
				"name": "홍길동",
				"hp" : "010-4321-4321",
				"pos" : "테스터",
				"dep" : 5,
				"rdate"	: "2023-01-16"
			}
		
		$.ajax({
			url		: '/Ch09/member',
			method	: 'PUT',
			data	: jsonData,
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//member 삭제 요청
	$('.memberDelete').click(function(){
		
		$.ajax({
			url		: '/Ch09/member/r101',
			method	: 'DELETE',
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
});
		