/*
 * OrderTable 생성
 */
 
 
 function createOrderTable(selectedProdNo){
	
	$(function(){
					$('.orderTable').empty();
					
					$('.orderTable').append("<h4>주문하기</h4>");
					let tableTag 	=  "<table border='1'>"
						tableTag	+= "<tr>";
						tableTag	+= "<td>상품번호</td>";
						tableTag	+= "<td><input type='text' name='prodNo' readonly/></td>";
						tableTag	+= "</tr>";
						tableTag	+= "<tr>";
						tableTag	+= "<td>수량</td>";
						tableTag	+= "<td><input type='text' name='count'/></td>";
						tableTag	+= "</tr>";
						tableTag	+= "<tr>";
						tableTag	+= "<td>주문자</td>";
						tableTag	+= "<td><input type='text' name='custId'/></td>";
						tableTag	+= "</tr>";
						tableTag	+= "<tr>";
						tableTag	+= "<td colspan='2' align='right'><input type='submit' value='제출'/></td>";
						tableTag	+= "</tr>";
						tableTag	+= "</table>";
						
					$('.orderTable').append(tableTag);
					$('input[name=prodNo]').val(selectedProdNo);
	});
	
}
 
