// registerSeller
let regCompany = /^[(주)]+[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]{1,10}$/; //회사명
let regCeo  = /^[가-힣]{2,4}$/; //대표자명
let regBiz	 = /^\d{3}-\d{2}-\d{5}$/; //사업자 등록번호
let regCom = /^[가-힣0-9-]{7,100}$/; //통신판매업신고번호
let regTel = /^(070|02|031|032|033|041|042|043|051|052|053|054|055|061|062|063|064)-\d{3,4}-\d{4}$/u; //전화
let regFax = /^\d{3,4}-\d{3}-\d{4}$/;//팩스

let isCompanyOk = false;
let isCeoOk = false;
let isBizOk = false;
let isComOk = false;
let isTelOk = false;
let isFaxOk = false;

$(function(){
	
	//회사명
	$('input[name=company]').focusout(function(){
		let company = $('input[name=company]').val();
		
		if(!company.match(regCompany)){
			isCompanyOk = false;
			$('.msgCompany').css('color','red').text('(주)포함 입력하여 입력해주세요.');
		}else{
			isCompanyOk = true;
			$('.msgCompany').text('');
		}
		
	});
	
	//담당자 이름
	$('input[name=manager]').focusout(function(){
		let name = $(this).val();
		if(!name.match(regName)){
			isNameOK = false;
			$('.manager').css('color','red').text('이름은 한글 2자 이상 이어야 합니다.');			
		}else{
			isNameOK = true;
			$('.manager').text('');
		}
	});
	//담당자 이름 끝
	
	// 담당자 휴대폰
	$('input[name=managerHp]').focusout(function(){
		let hp = $(this).val();
		
		if(!hp.match(regHp)){
			isHpOK = false;
			$('.mgHp').css('color', 'red').text('휴대폰이 유효하지 않습니다.');
		}else{
			isHpOK = true;
			$('.mgHp').text('');
		}
	});
	//담당자 휴대폰 끝
	

});