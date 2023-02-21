/**
 * 
 */
$(function(){
	let now = new Date();
	$('.month1').text(now.getMonth()+1);
	now.setMonth(now.getMonth() -1);
	$('.month2').text(now.getMonth()+1);
	now.setMonth(now.getMonth() -1);
	$('.month3').text(now.getMonth()+1);
	now.setMonth(now.getMonth() -1);
	$('.month4').text(now.getMonth()+1);
	now.setMonth(now.getMonth() -1);
	$('.month5').text(now.getMonth()+1);
	
	$('.off').on('click', function(){
		$('.on').attr('class','off');
		$(this).attr('class','on');
	});
	
	//오늘
	let today = new Date();
	let lastDay = dateFormat(today);
	
	//7일전
	$('#1week').click(function(){
		today = new Date();
		let firstDay = new Date(today.setDate(today.getDate()-7));
		firstDay = dateFormat(firstDay);
		list(firstDay, lastDay);
	});
	//15일전
	$('#15day').click(function(){
		today = new Date();
		let firstDay = new Date(today.setDate(today.getDate()-15));
		firstDay = dateFormat(firstDay);
		list(firstDay, lastDay);
	});
	//30일전
	$('#1month').click(function(){
		today = new Date();
		let firstDay = new Date(today.setDate(today.getDate()-30));
		firstDay = dateFormat(firstDay);
		list(firstDay, lastDay);
	});
	//당월
	$('#month1').click(function(){
		today = new Date();	
		let firstDay = new Date(today.getFullYear(), today.getMonth(), 1);
		let lastDay = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		firstDay = dateFormat(firstDay);
		lastDay = dateFormat(lastDay);
		list(firstDay, lastDay);
	});
	//1달전
	$('#month2').click(function(){
		today = new Date();	
		let firstDay = new Date(today.getFullYear(), today.getMonth()-1, 1);
		let lastDay = new Date(today.getFullYear(), today.getMonth(), 0);
		firstDay = dateFormat(firstDay);
		lastDay = dateFormat(lastDay);
		list(firstDay, lastDay);
	});
	//2달전
	$('#month3').click(function(){
		today = new Date();	
		let firstDay = new Date(today.getFullYear(), today.getMonth()-2, 1);
		let lastDay = new Date(today.getFullYear(), today.getMonth()-1, 0);
		firstDay = dateFormat(firstDay);
		lastDay = dateFormat(lastDay);
		list(firstDay, lastDay);
	});
	//3달전
	$('#month4').click(function(){
		today = new Date();	
		let firstDay = new Date(today.getFullYear(), today.getMonth()-3, 1);
		let lastDay = new Date(today.getFullYear(), today.getMonth()-2, 0);
		firstDay = dateFormat(firstDay);
		lastDay = dateFormat(lastDay);
		list(firstDay, lastDay);
	});
	//4달전
	$('#month5').click(function(){
		today = new Date();	
		let firstDay = new Date(today.getFullYear(), today.getMonth()-4, 1);
		let lastDay = new Date(today.getFullYear(), today.getMonth()-3, 0);
		firstDay = dateFormat(firstDay);
		lastDay = dateFormat(lastDay);
		list(firstDay, lastDay);
	});
	//사용자 지정
	$('.search').click(function(){
		let start = $('input[name=start]').val();
		let end = $('input[name=end]').val();
		if(start == "" || end == ""){
			alert('날짜를 선택해주세요.');
			return false;
		}
		
		today = new Date();	
		let firstDay = new Date(today.setFullYear(today.getFullYear() - 1));
		firstDay = dateFormat(firstDay);
		if(start < firstDay){
			alert('전체주문내역의 최대 1년치까지만 조회가능합니다.');
			start = firstDay;
		}
		list(start, end);
		$('.on').attr('class','off');
	});
	
	function dateFormat(date) {
		let dateFormat2 = date.getFullYear() +
			'-' + ( (date.getMonth()+1) < 9 ? "0" + (date.getMonth()+1) : (date.getMonth()+1) )+
			'-' + ( (date.getDate()) < 9 ? "0" + (date.getDate()) : (date.getDate()) );
		return dateFormat2;
	}
	
	function list(start, end){
		let jsonData = {
				'start' : start,
				'end' : end
		}
		console.log(jsonData);
		$.ajax({
			url : '/Kmarket/mypage/orderList/',
			method : 'POST',
			data : jsonData,
			dataType : 'JSON',
			success : function(data){
				console.log(data.result);
			}
		});
	}
});