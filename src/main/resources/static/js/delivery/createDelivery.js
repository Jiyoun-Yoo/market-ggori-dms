$(function(){
  var modalToggle = document.getElementById('modal_selectDriver') // relatedTarget
  myModal.show(modalToggle)

});

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

  $('#devlieryForm').submit();
}

function checkDriver() {
  $.ajax({
    url: "checkDriver",
    type: "POST",
    data: {driver_name:$("#driver_usr_name").val()},
    success: function (data) {
      if (data.result == "success") {
        $("#modal_selectDriver").show();
        alert("확인이 완료되었습니다.");

      } else if (data.result == "select") {
        $('#modal_selectDriver').on('show.bs.modal', function(event) {
        });

      }

      alert(data.errorMsg);
      $("#driver_usr_name").focus();
    },
    error: function (error) {
      alert("error : " + error);
    }
  });
}