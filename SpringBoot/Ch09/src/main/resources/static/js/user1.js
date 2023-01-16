/**
 * 
 */

 		
$(document).ready(function(){
	//user1 목록 요청
	$('.user1List').click(function(){
		$.ajax({
			url		: '/Ch09/user1',
			method	: 'GET',
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//user1 조회 요청
	$('.user1Select').click(function(){
		$.ajax({
			url		: '/Ch09/user1/r101',
			method	: 'GET',
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//user1 등록 요청
	$('.user1Register').click(function(){
		let jsonData = {
				"uid": "r101",
				"name": "홍길동",
				"hp" : "010-1234-1234",
				"age" : 21
			}
		
		$.ajax({
			url		: '/Ch09/user1',
			method	: 'POST',
			data	: jsonData,
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//user1 수정 요청
	$('.user1Modify').click(function(){
		let jsonData = {
				"uid": "r101",
				"name": "홍길동",
				"hp" : "010-4321-4321",
				"age" : 27
			}
		
		$.ajax({
			url		: '/Ch09/user1',
			method	: 'PUT',
			data	: jsonData,
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
	//user1 삭제 요청
	$('.user1Delete').click(function(){
		
		$.ajax({
			url		: '/Ch09/user1/r101',
			method	: 'DELETE',
			dataType: 'json',
			success	: function(data){
				console.log(data);
			}
		});
	});
	
});
		