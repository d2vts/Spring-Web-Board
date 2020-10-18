var userIdCheck = 0, userPassword1Check = 0, userPassword2Check = 0, userNameCheck = 0, userNicknameCheck = 0, userEmailCheck = 0;


$(function () {
	//아이디 중복검사 및 정규표현식 검사
	$('#userId').blur(function () {
		$.ajax({
	        type: "POST",
	        url: "check_id_ajax",
	        data: {"userId": $('#userId').val()},
	        success: function(data){
				if($('#userId').val() !=''){
	        	if ($.trim(data) != $('#userId').val()) {
						var id = $("#userId").val();
						var idForm = /^[a-z0-9]{4,15}$/;
						if (false === idForm.test(id)) {
							$("#sign-check-info-id").css("color", "red").css('font-size', '8px').text('영 소문자, 숫자 4~15자리로 입력해주세요.');
							userIdCheck = 0;
						}else{
							$("#sign-check-info-id").css("color", "green").css('font-size', '8px').text('사용할 수 있는 아이디입니다.');
							userIdCheck = 1;
						}
	        	}else{
	        		$("#sign-check-info-id").css("color", "red").css("font-size", "8px").text('이미 사용중인 아이디 입니다.');
					userIdCheck = 0
				}
	        }else{
				$("#sign-check-info-id").css("color", "red").css("font-size", "8px").text('필수 정보 입니다.');
				userIdCheck = 0
			}
		},error: function(){
	            alert('DB조회 실패');
			}
	});
});
	
	//비밀번호 정규표현식 검사
	$('#userPassword').blur(function () {
        var userPassword = $("#userPassword").val();
        var passwordForm = /^(?=.*?[a-zA-Z])(?=.*?[0-9]).{4,20}$/;
        if ($('#userPassword').val() != '') {
            if (false === passwordForm.test(userPassword)) {
                $("#sign-check-info-pw").css("color", "red").css('font-size', '8px').text('4~20자 영문과 숫자를 사용하셔야 합니다.');
                userPassword1Check = 0;
            } else {
                $("#sign-check-info-pw").css("color", "#2DB400").css("font-size", "8px").text('사용 가능합니다.');
                userPassword1Check = 1;
            }
        } else {
            $("#sign-check-info-pw").css("color", "red").css("font-size", "8px").text('필수 정보 입니다.');
            userPassword1Check = 0;
        }
    })
	
	//비밀번호&비밀번호 일치 확인
    $('#userPassword2').blur(function () {
	 	var userPassword2 = $("#userPassword2").val();
        var passwordForm2 = /^(?=.*?[a-zA-Z])(?=.*?[0-9]).{4,20}$/;
        if ($('#userPassword').val() != $('#userPassword2').val()) {
            if ($('#userPassword2').val() != '') {
                $("#sign-check-info-pw2").css("color", "red").css("font-size", "8px").text('비밀번호가 일치하지 않습니다.');
                userPassword2Check = 0;
            } else {
                $("#sign-check-info-pw2").css("color", "red").css("font-size", "8px").text('필수정보 입니다.');
                userPassword2Check = 0;
            }
        } else {
            if ($('#userPassword2').val() != '') {
	
				if (false === passwordForm2.test(userPassword2)) {
			                $("#sign-check-info-pw2").css("color", "red").css('font-size', '8px').text('4~20자 영문이나 숫자를 사용하셔야 합니다.');
			                userPassword2Check = 0;
			     } else {
			                $("#sign-check-info-pw2").css("color", "#2DB400").css("font-size", "8px").text('비밀번호 일치');
			                userPassword2Check = 1;
			     }
            } else {
                $("#sign-check-info-pw2").css("color", "red").css("font-size", "8px").text('필수정보 입니다.');
                userPassword2Check = 0;
            }
        }
    })
		
		$('#userName').blur(function () {
        var userName = $("#userName").val();
        var usernameForm = /^[a-zA-Z가-힣]{2,10}$/;
        if ($('#userName').val() != '') {
            if (false === usernameForm.test(userName)) {
                $("#sign-check-info-name").css("color", "red").css('font-size', '8px').text('2 - 10 글자 사이 한글이나 영어로 작성해주세요');
                userNameCheck = 0;
            } else {
                $("#sign-check-info-name").css("color", "#2DB400").css("font-size", "11px").text('확인');
                userNameCheck = 1;
            }
        } else {
            $("#sign-check-info-name").css("color", "red").css("font-size", "11px").text('필수 정보 입니다.');
            userNameCheck = 0;
        }
    })
		
		
	$('#userNickname').blur(function () {
		$.ajax({
	        type: "POST",
	        url: "check_nickname_ajax",
	        data: {"userNickname": $('#userNickname').val()},
	        success: function(data){
			if($('#userNickname').val() !=''){
				var nickname = $("#userNickname").val();
                var nicknameForm = /^[a-zA-Z0-9가-힣]{2,8}$/;

	        	if (data != $('#userNickname').val()) {
	
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

    $('#userId').focus();
    $('#userId').blur();

    $('#userPassword').focus();
    $('#userPassword').blur();

    $('#userPassword2').focus();
    $('#userPassword2').blur();

    $('#userName').focus();
    $('#userName').blur();

    $('#userNickname').focus();
    $('#userNickname').blur();

    $('#userEmail').focus();
    $('#userEmail').blur();


    if (userIdCheck == 0) {
        alert('아이디 조건이 맞지 않습니다.');
        return false;
    } else if (userPassword1Check == 0) {
        alert('비밀번호 조건이 맞지 않습니다.');
        return false;
    } else if (userPassword2Check == 0) {
        alert('비밀번호 확인이 일치하지 않습니다.');
        return false;
    } else if (userNameCheck == 0) {
        alert('이름 조건이 맞지 않습니다.');
        return false;
	}else if (userNicknameCheck == 0) {
        alert('닉네임 조건이 맞지 않습니다.');
        return false;
    } else if (userEmailCheck == 0) {
        alert('이메일 조건이 맞지 않습니다.');
        return false;
    } else{
        return true;
    }
}