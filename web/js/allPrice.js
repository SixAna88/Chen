function allCheck(checkbox) {
    var oCheck = document.getElementsByName("check");
    if (checkbox.checked) {
        for (var i = 0; i < oCheck.length; i++) {
            oCheck[i].checked = true;
        }
    } else {
        for (var i = 0; i < oCheck.length; i++) {
            oCheck[i].checked = false;
        }
    }
}

function deletePrice() {
    if (!confirm("确认要删除？")) {
        window.event.returnValue = false;
    }
}