/*
 * 학생등록 테이블 생성 코드
 */


function createStdTable(){
	
	$(function(){
		$('.stdTable').empty();
					
		$('.stdTable').append("<h4>강좌등록</h4>");
		$('.stdTable').append("<button type='button' class='btnCloseStdTable'>닫기</button>");
		let tableTag 	=  "<table border='1'>"
			tableTag	+= "<tr>";
			tableTag	+= "<td>학번</td>";
			tableTag	+= "<td><input type='text' name='stdNo'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>이름</td>";
			tableTag	+= "<td><input type='text' name='stdName'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>휴대폰</td>";
			tableTag	+= "<td><input type='text' name='stdHp'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>학년</td>";
			tableTag	+= "<td><input type='text' name='stdYear'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>주소</td>";
			tableTag	+= "<td><input type='text' name='stdAddress'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td colspan='2' align='right'><input type='submit' value='추가'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "</table>";
			
		$('.stdTable').append(tableTag);
	});
	
}

function closeStdTable(){
	$('.stdTable').empty();
}

function registerStdTable(){
	$(function(){
		//데이터 가져오기
		let stdNo = $('input[name=stdNo]').val();
		let stdName = $('input[name=stdName]').val();
		let stdHp = $('input[name=stdHp]').val();
		let stdYear = $('input[name=stdYear]').val();
		let stdAddress = $('input[name=stdAddress]').val();
		
		//JSON 데이터 생성
		let jsonData = {
			"stdNo":stdNo,
			"stdName":stdName,
			"stdHp":stdHp,
			"stdYear":stdYear,
			"stdAddress":stdAddress
		}
		
		//데이터 전송
		$.ajax({
	        url: '/College/proc/registerStdProc.jsp',
	        type: 'POST',
	        data: jsonData,
	        datatype: 'json',
	        success:function(data){
	            if(data.result == 1){
	            	alert('추가 완료!');
	            }else{
	            	alert('입력 정보를 확인해주세요.');
	            }
	        }
	    });
	});
	
}