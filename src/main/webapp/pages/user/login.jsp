<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ForestAtNight</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#img").click(function () {
              this.src="${basePath}"+"kaptcha.jpg?d="+ new Date();
            });
            $("button").click(function () {
                var getname=$("#name").val();
                var namePatt=/^\w{5,12}$/;
                if(!namePatt.test(getname)){
                    $(".warn").text("用户名或密码错误，请重新输入!");
                    return false;
                }
                var getpassword=$("#password").val();
                var passwordPatt=/^\w{5,12}$/;
                if(!passwordPatt.test(getpassword)){
                    $(".warn").text("用户名或密码错误，请重新输入!");
                    return false;
                }
                var getcode=$("#code").val();
                if(getcode==null || getcode==""){
                    $(".warn").text("验证码不能为空！");
                    return false;
                }
                $(".warn").text("");

            });

        });

    </script>

</head>
<body id="login_body">
<h1>FOREST AT NIGHT</h1><br/>
<ul >
    <div  align="right">
        <li> <div class="sign" >
            会员登录</div></li>
        <form action="userServlet/login" method="post">
            <input type="hidden" name="action" value="login">
            <span  class="warn" >
               ${empty requestScope.code?(empty requestScope.msg?"":requestScope.msg):requestScope.code}
            </span>
            <li class="l01"> 输入用户名: <input id="name" name="username" type="text" placeholder="请输入用户名"
                                           value="${empty requestScope.username?"":requestScope.username}"></li>
            <li class="l01"> 输入密码: <input id="password" name="password" type="password" placeholder="请输入密码"></li>
            <li class="l01">验证码: <input name="code" id="code" type="text" placeholder="请输入验证码"></li>
            <li><img id="img"  src="kaptcha.jpg" height=50 width=200/></li>
            <li ><button class="login_b" type="submit" >登录</button></li>
            <li ><a style="color: red;font-size: small ;font-family: 'Roboto'" href="pages/user/register.jsp">还没成为会员？立即注册</a></li>
        </form>

    </div>
    <%@include file="/pages/common/footer.jsp"%>
</ul>
</body>
</html>