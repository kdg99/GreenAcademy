/*
 * 주문하기 기능
 */
 
 function order(){
	$(function(){
		
		//데이터 가져오기
		let prodNo = $('input[name=prodNo]').val();
		let count = $('input[name=count]').val();
		let custId = $('input[name=custId]').val();
		
		//JSON 데이터 생성
		let jsonData = {
			"prodNo":prodNo,
			"count":count,
			"custId":custId
		}
		
		//데이터 전송
		$.ajax({
            url: '/Shop/json/registerProc.jsp',
            type: 'POST',
            data: jsonData,
            datatype: 'json',
            success:function(data){
                if(data.result == 1){
                	alert('주문완료!');
                }else{
                	alert('주문 정보를 확인해주세요.');
                }
            }
        });
		
	});
}