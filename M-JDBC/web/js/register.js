function check() {
       // alert("in check method...");

    if (form.gid.value == "") {
        alert("请输入用户编号！");
        form.gid.focus();
        return false;
    }
//正则表达式
    var regm = /^g[0-9][0-9]$/
    if (form.gid.value != "" && !form.gid.value.match(regm)) {
        alert("您输入的编号格式有误，请输入以g开头的，后面是两位正整数");
        form.gid.focus();
        return false;
    }

    if (form.gname.value == "") {
        alert("请输入用户姓名！");
        form.gname.focus();
        return false;
    }
    if (form.password.value == "") {
        alert("请输入用户密码！");
        form.password.focus();
        return false;
    }
    if (form.password1.value == "") {
        alert("请再次输入用户密码！");
        form.password1.focus();
        return false;
    }

    if (form.password1.value != form.password.value) {
        alert("两次密码输入不一致！");
        form.password1.focus();
        return false;
    }
    if (form.superuser.value == "") {
        alert("请输入用户权限！");
        form.superuser.focus();
        return false;
    }
    if (form.flag.value == "") {
        alert("请选择用户备注信息！");
        form.flag.focus();
        return false;
    }
}
