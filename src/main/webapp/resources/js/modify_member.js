var userNicknameCheck =0, userEmailCheck = 0;

$(function () {
	$('#userNickname').blur(function () {
		$.ajax({
	        type: "POST",
	        url: "/board/check_nickname_ajax",
	        data: {"userNickname": $('#userNickname').val()},
	        success: function(data){
			if($('#userNickname').val() !=''){
				var nickname = $("#userNickname").val();
                var nicknameForm = /^[a-zA-Z0-9가-힣]{2,8}$/;

	        	if ($.trim(data) != $('#userNickname').val()) {
	
						if (false === nicknameForm.test(nickname)) {
							$("#sign-check-info-nick").css("color", "red").css('font-size', '8px').text('공백없이 영문,한글,숫자사용가능 2~8자리로 가능합니다.');
							userNicknameCheck = 0;
						}else{
							$("#sign-check-info-nick").css("color", "green").css('font-size', '8px').text('사용할 수 있는 닉네임입니다.');
							userNicknameCheck = 1;
						}
	        	}else{
	        		$("#sign-check-info-nick").css("color", "red").css("font-size", "8px").text('이미 사용중인 닉네임 입니다.');
					userNicknameCheck = 0;
				}
	        }else{
				$("#sign-check-info-nick").css("color", "red").css("font-size", "8px").text('필수 정보 입니다.');
				userNicknameCheck = 0;
			}
		},error: function(){
	            alert('DB조회 실패');
	        }
	});
});

$('#userEmail').blur(function () {
        var email = $("#userEmail").val();
		var emailForm = /^[a-zA-Z0-9](?=.*?[@])(?=.*?[a-z])(?=.*?[.])(?=.*?[a-z]).{8,20}$/
        if ($('#userEmail').val() != '') {
            if (false === emailForm.test(email)) {
                $("#sign-check-info-email").css("color", "red").css('font-size', '8px').text('이메일 양식을 벗어납니다.');
                userEmailCheck = 0;
            } else {
                $("#sign-check-info-email").css("color", "#2DB400").css("font-size", "11px").text('사용 가능합니다.');
                userEmailCheck = 1;
            }
        } else {
            $("#sign-check-info-email").css("color", "red").css("font-size", "11px").text('필수 정보 입니다.');
            userEmailCheck = 0;
        }
    });
})
function noSpaceForm(obj) { // 공백사용못하게
	var str_space = /\s/;  // 공백체크
	if (str_space.exec(obj.value)) { //공백 체크
		alert("해당 항목에는 공백을 사용할수 없습니다.\n\n공백은 자동적으로 제거 됩니다.");
		obj.focus();
		obj.value = obj.value.replace(' ', ''); // 공백제거
		return false;
	}
	// onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
}


function submitCheck() {
	
	$('#userNickname').focus();
    $('#userNickname').blur();

    $('#userEmail').focus();
    $('#userEmail').blur();

    if (userNicknameCheck == 0) {
        alert('닉네임 조건이 맞지 않습니다.');
        return false;
    } else if (userEmailCheck == 0) {
        alert('이메일 조건이 맞지 않습니다.');
        return false;
    } else{
        return true;
    }
}

