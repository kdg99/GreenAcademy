/*
 * 학생등록 테이블 생성 코드
 */
function stdAdd(addedStd){

	$(function(){
		
		let sb = JSON.parse(addedStd);
		
		let	tableTag	 = "<tr>";
			tableTag	+= "<td>"+sb.stdNo+"</td>";
			tableTag	+= "<td>"+sb.stdName+"</td>";
			tableTag	+= "<td>"+sb.stdHp+"</td>";
			tableTag	+= "<td>"+sb.stdYear+"</td>";
			tableTag	+= "<td>"+sb.stdAddress+"</td>";
			tableTag	+= "</tr>";
			
		$('.stdList > table').append(tableTag);
	});

}

function createRegTable(){
	
	$(function(){
		$('.regTable').empty();
					
		$('.regTable').append("<h4>강좌등록</h4>");
		$('.regTable').append("<button type='button' class='btnCloseRegTable'>닫기</button>");
		let tableTag 	=  "<table border='1'>"
			tableTag	+= "<tr>";
			tableTag	+= "<td>학번</td>";
			tableTag	+= "<td><input type='text' name='regStdNo'/></td>";
			tableTag	+= "</tr>";
			tableTag	+= "<tr>";
			tableTag	+= "<td>강좌명</td>";
			tableTag	+= "<td><select name='regLecNo>";
			tableTag	+= "<option value="+value+">"+value+"</option>";
			tableTag	+= "</select></td>";
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