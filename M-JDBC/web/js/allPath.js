function allCheck(checkbox) {
    // alert("[Debug] in allCheck method");
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

function deleteAll() {
    var allPid = new Array();
    var flag = false;
    var oCheck = document.getElementsByName("check");
    for (var i = 0; i < oCheck.length; i++) {
        if (oCheck[i].checked) {
            flag = true;
            allPid.push(oCheck[i].value);
        }
    }
    if (flag == true) {
        if (confirm("温馨提示：您是否确定删除这些记录，记录删除后将不可还原！")) {
            location.href = "/deletePath?flag=all&pid=" + allPid;
        }
    } else {
        alert("温馨提示：您至少要选择一条记录，才能点击批量删除！")
    }
}


function deletePath() {
    if (!confirm("确认要删除？")) {
        window.event.returnValue = false;
    }
}