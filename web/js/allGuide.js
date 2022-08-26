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
    var allSid = new Array();
    var flag = false;
    var oCheck = document.getElementsByName("check");
    for (var i = 0; i < oCheck.length; i++) {
        if (oCheck[i].checked) {
            flag = true;
            allSid.push(oCheck[i].value);
        }
    }
    // alert("[debug]: in deleteAll method ,allAid = "+ allSid);
    if (flag == true) {
        if (confirm("温馨提示：您是否确定删除这些记录，记录删除后将不可还原！")) {
            location.href = "/deleteGuide?flag=all&gid=" + allSid;
        }
    } else {
        alert("温馨提示：您至少要选择一条记录，才能点击批量删除！")
    }
}


function deleteGuide() {
    if (!confirm("确认要删除？")) {
        window.event.returnValue = false;
    }
}
