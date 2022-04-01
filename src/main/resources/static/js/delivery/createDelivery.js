$(function(){

});

var check_driver = false;
var driver_name;

 function checkInput() {
  if ($('#departure').val() == '' || $('#departure').val() == null) {
    alert("출발지를 입력하세요.");
    return false;
  }

  if ($('#destination').val() == '' || $('#destination').val() == null) {
    alert("도착지를 입력하세요.");
    return false;
  }

  if ($('#requestedCompany').val() == '' || $('#requestedCompany').val() == null) {
    alert("요청업체를 입력하세요.");
    return false;
  }

  if ($('#driver_usr_name').val() == '' || $('#driver_usr_name').val() == null) {
    alert("운송담당자를 입력하세요.");
    return false;
  }

  if ($('#product').val() == '' || $('#product').val() == null) {
    alert("물품 정보를 입력하세요.");
    return false;
  }

  if ($('#requestedDate').val() == '' || $('#requestedDate').val() == null) {
    alert("운반 날짜를 입력하세요.");
    return false;
  }

  if ($('#requestedTime').val() == '' || $('#requestedTime').val() == null) {
    alert("운반 시간을 입력하세요.");
    return false;
  }

  if(!check_driver || $("#driver_usr_name").val() != driver_name) {
    alert("운송 담당자 정보를 확인하세요.");
    return false;
  }

  $('#deliveryForm').submit();
}

function checkDriver() {
  $.ajax({
    url: "checkDriver",
    type: "POST",
    data: {driver_name:$("#driver_usr_name").val()},
    success: function (data) {
      if (data.result == "success") {
        driver_name = $("#driver_usr_name").val();
        check_driver = true;
        alert("확인이 완료되었습니다.");
        return;
      }

      alert(data.errorMsg);
      $("#driver_usr_name").focus();
    },
    error: function (error) {
      alert("error : " + error);
    }
  });
}