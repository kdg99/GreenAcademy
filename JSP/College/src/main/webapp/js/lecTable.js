/*
 * 강좌등록 테이블 생성 코드
 */
function init(lectures){

	$(function(){
		
		$('.lecList').empty();
				
		$('.lecList').append("<h4>강좌현황</h4>");
		$('.lecList').append("<button type='button' class='btnCreateLecTable'>등록</button>");
		let tableTag 	=  "<table border='1'>"
			tableTag	+= "<tr>";
			tableTag	+= "<th>번호</th>";
			tableTag	+= "<th>강좌명</th>";
			tableTag	+= "<th>학점</th>";
			tableTag	+= "<th>시간</th>";
			tableTag	+= "<th>강의장</th>";
			tableTag	+= "</tr>";
			for(let lb in lectures){}
			tableTag	+= "</table>";
			
		$('.lecList').append(tableTag);
	});

}

function createLecTable(){
	
	$(function(){
		$('.lecTable').empty();
					
		$('.lecTable').append("<h4>강좌등록</h4>");
		$('.lecTable').append("<button type='button' class='btnCloseLecTable'>닫기</button>");
		let tableTag 	=  "<table border='1'>"
			tableTag	+= "<tr>";
			tableTag	+= "<td>번호</td>";
			tableTag	+= "<td><input type='text' name='lecNo'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>강좌명</td>";
			tableTag	+= "<td><input type='text' name='lecName'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>학점</td>";
			tableTag	+= "<td><input type='text' name='lecCredit'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>시간</td>";
			tableTag	+= "<td><input type='text' name='lecTime'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>강의장</td>";
			tableTag	+= "<td><input type='text' name='lecClass'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td colspan='2' align='right'><input type='submit' value='추가'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "</table>";
			
		$('.lecTable').append(tableTag);
	});
	
}

function closeLecTable(){
	$('.lecTable').empty();
}

function registerLecTable(){
	
	$(function(){
	
		//데이터 가져오기
		let lecNo = $('input[name=lecNo]').val();
		let lecName = $('input[name=lecName]').val();
		let lecCredit = $('input[name=lecCredit]').val();
		let lecTime = $('input[name=lecTime]').val();
		let lecClass = $('input[name=lecClass]').val();
		
		//JSON 데이터 생성
		let jsonData = {
			"lecNo":lecNo,
			"lecName":lecName,
			"lecCredit":lecCredit,
			"lecTime":lecTime,
			"lecClass":lecClass
		}
		
		//데이터 전송
		$.ajax({
	        url: '/College/proc/registerLecProc.jsp',
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