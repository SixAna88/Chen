function check() {
    if(form.username.value==""){
        alert("请输入用户名！");
        form.username.focus();
        return false;
    }

    if(form.password.value==""){
        alert("请输入登录密码！");
        form.password.focus();
        return false;
    }

}