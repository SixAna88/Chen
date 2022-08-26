<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="shortcut icon" href="img/favicon.ico">
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        /* 设置整个表单参数 (父盒子)*/

        section {
            position: relative;
            min-height: 100vh;
            background: lightblue;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        section .container {
            position: relative;
            width: 800px;
            height: 500px;
            background: #fff;
            box-shadow: 0 15px 50px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        section .container .user {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            display: flex;
        }

        /* 更改图片  （左侧）*/
        section .container .imgBx {
            position: relative;
            width: 50%;
            height: 100%;
            /* background: #fff; */
            transition: .5s;
        }

        section .container .user .imgBx img {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        /* 右侧表单盒子 */

        section .container .user .formBx {
            position: relative;
            width: 50%;
            height: 100%;
            background: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 40px;
            transition: .5s;
        }

        /* h2 */

        section .container .user .formBx form h2 {
            font-size: 18px;
            font-weight: 600;
            text-transform: uppercase; /*大小*/
            letter-spacing: 2px; /* 间距*/
            text-align: center;
            width: 100%;
            margin-bottom: 10px;
            color: #555;
        }

        /* 表单文字属性 */

        section .container .user .formBx form input, select {
            position: relative;
            width: 100%;
            padding: 10px;
            background: #f5f5f5;
            color: #333;
            border: none;
            outline: none;
            box-shadow: none;
            margin: 8px 0;
            font-size: 14px;
            letter-spacing: 1px;
            font-weight: 300;
        }

        /* 为登录设置样式 */
        section .container .user .formBx form input[type="submit"] {
            max-width: 100px;
            background: #677eff;
            color: #fff;
            cursor: pointer;
            font-size: 14px;
            font-weight: 500;
            letter-spacing: 1px;
            transition: .5s;
        }

        /* 没有账号时 */
        section .container .user .formBx form .signup {
            position: relative;
            margin-top: 20px;
            font-size: 12px;
            letter-spacing: 1px;
            color: #555;
            text-transform: uppercase;
            font-weight: 300;
        }

        section .container .user .formBx form .signup a {
            font-weight: 600;
            text-decoration: none;
            color: #677eff;
        }

        section .container .singupBx {
            pointer-events: none;
        }

        section .container.active .singupBx {
            pointer-events: initial;
        }

        section .container .singupBx .formBx {
            left: 100%;
        }

        section .container.active .singupBx .formBx {
            left: 0;
        }

        section .container .singupBx .imgBx {
            left: -100%;
        }

        section .container.active .singupBx .imgBx {
            left: 0;
        }

        section .container .singinBx .formBx {
            left: 0;
        }

        section .container.active .singinBx .formBx {
            left: 100%;
        }

        section .container .singinBx .imgBx {
            left: 0;
        }

        section .container.active .singinBx .imgBx {
            left: 100%;
        }

        @media (max-width: 991px) {
            section .container {
                max-width: 400px;
            }

            section .container .imgBx {
                display: none;
            }

            section .container .user .formBx {
                width: auto;
            }
        }
    </style>
</head>
<body>
<section>

    <!-- 登录 -->
    <div class="container">
        <div class="user singinBx">
            <div class="imgBx"><img src="img/1.jpg" alt=""></div>
            <div class="formBx">
                <form action="/login" name="" method="post">
                    <h1 style="text-align: center;">登录</h1>
                    <input type="text" name="username" required lay-verify="required" placeholder="用户名">
                    <input type="password" name="password" required lay-verify="required" placeholder="密码">
                    <select name="role" required lay-verify="required">
                        <option value="管理员">管理员登录</option>
                        <%--默认选中用户登录--%>
                        <option value="用户" selected="">用户登录</option>
                    </select>
                    <input type="submit" value="登录">
                    <p class="signup">没有账号？<a href="#" onclick="topggleForm();">注册</a></p>
                </form>

                <script>
                    //Demo
                    layui.use('form', function () {
                        var form = layui.form;

                        //提交
                        form.on('submit(formDemo)', function (data) {
                            layer.msg(JSON.stringify(data.field));
                            return false;
                        });
                    });
                </script>
            </div>
        </div>

        <!-- 注册 -->
        <div class="user singupBx">
            <div class="formBx">
                <form action="/register" name="" method="post">
                    <h1 style="text-align: center">注册</h1>
                    <input type="text" name="username" placeholder="用户名">
                    <input type="password" name="password" placeholder="密码">
                    <input type="password" name="password1" placeholder="再次输入密码">
                    <input type="submit" name="" value="注册">
                    <p class="signup">已有账号？<a href="#" onclick="topggleForm();">登录</a></p>
                </form>
            </div>
            <div class="imgBx"><img src="img/4.jpg" alt=""></div>
        </div>

    </div>
</section>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

    function topggleForm() {
        var container = document.querySelector('.container');
        container.classList.toggle('active');
    }
</script>
</body>
</html>
