jQuery(document).ready(function() {

});

let id_flag = false;
let pwd_flag = false;
let cheked_id = '';
let cheked_pwd = '';

function checkID() {
  $.ajax({
    url: "/checkID",
    type: "POST",
    data: $("#usr_id").val(),
    success: function (data) {
      if (data.result == true) {
        alert("사용 가능한 아이디입니다.");
        $("#usr_id").disabled = true;
        $("#usr_pwd").focus();

        id_flag = true;
        let cheked_id = '';
      } else {
        alert(data.errorMsg);
        // $("#usr_id").addClass("has-error")
        // $("#usr_id").removeClass("has-success")
        $("#usr_id").focus();

      }
    },
    error: function (error) {
      if (this.data == null) {
        alert("아이디를 입력하지 않았습니다.");
      }
      alert("error : " + error);
    }
  });
}

function checkPW() {
  $.ajax({
    url: "/checkPW",
    type: "POST",
    data: {usr_pwd:$("#usr_pwd").val(), confirm_pwd:$("#confirm_pwd").val()},
    success: function (data) {
      if (data.result == true) {
        pwd_flag = true;
        alert("비밀번호 확인이 완료되었습니다.");
      }

      alert(data.errorMsg);
      $("#usr_pwd").focus();

    }
  });

}

function checkInput() {
  var name = $("#name").val();
  var svc_id = $("#svc_id").val();
  var usr_id = $("#usr_id").val();
  var usr_pwd = $("#usr_pwd").val();
  var email = $("#email").val();
  var tel = $("#tel").val();

  if (name.length < 1) {
    alert("이름을 입력했는지 확인하세요.");
    return;
  }

  if (svc_id.length < 1) {
    alert("기업 아이디를 입력했는지 확인하세요.");
    return;
  }

  if (usr_id.length < 1) {
    alert("아이디를 입력했는지 확인하세요.");
    return;
  }

  if (usr_pwd.length < 1 || confirm_pwd.length < 1){
    alert("비밀번호를 입력했는지 확인하세요.");
    return;
  }

  if (email.length < 1) {
    alert("이메일을 입력했는지 확인하세요.");
    return;
  }

  if (tel.length < 1){
    alert("전화번호를 입력했는지 확인하세요.");
    return;
  }

  if (!id_flag || usr_id != cheked_id) {
    alert("아이디를 확인하세요.");
  }

  if (!pwd_flag) {
    alert("비밀번호를 확인하세요.");
  }

  $('#joinForm').submit();
}
