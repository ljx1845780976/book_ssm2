<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ForestAtNight</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
           $(function () {
               $("#name").blur(function () {
                  var username=this.value;
                   var namePatt=/^\w{5,12}$/;
                   if(!namePatt.test(username)){
                       $(".warn").text("用户名不合法！");
                   return;
                   }
                  $.getJSON("userServlet/ajaxExistUsername?","username="+username,function (data) {
                      if (data.existUsername){
                          $(".warn").text("用户名已存在！");
                      }else {
                          $(".warn").text("用户名可用！");
                      }
                  });
               });
               $("#img").click(function () {
                   this.src="${basePath}"+"kaptcha.jpg?d="+ new Date();
               });
                $(".login_b").click(function () {
                     var getname=$("#name").val();
                     var namePatt=/^\w{5,12}$/;
                     if(!namePatt.test(getname)){
                         $(".warn").text("用户名不合法！");
                         return false;
                     }
                    var getpassword=$("#password").val();
                    var passwordPatt=/^\w{5,12}$/;
                    if(!passwordPatt.test(getpassword)){
                        $(".warn").text("密码不合法！");
                        return false;
                    }
                    var getrepeat=$("#repeat").val();
                    if(getrepeat!=getpassword){
                        $(".warn").text("与上面的密码不一致！");
                        return false;
                    }
                    var getemail=$("#email").val();
                    var emailPatt=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                    if(!emailPatt.test(getemail)){
                        $(".warn").text("邮箱格式不合法！");
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
<body id="register_body">
<h1>FOREST AT NIGHT</h1><br/>
<ul >
    <div align="right">
     <li><div class="sign" >
       会员注册</div></li>
    <form action="userServlet/register" method="post">
    <span  class="warn" >
        ${empty requestScope.code?(empty requestScope.msg?"":requestScope.msg):requestScope.code}
    </span>
    <li class="l01"> 输入用户名: <input id="name" name="username" type="text" placeholder="请输入用户名"
                                value="${empty requestScope.username?"":requestScope.username}"></li>
    <li class="l01"> 输入密码: <input id="password" name="password"  type="password" placeholder="请输入密码"></li>
    <li class="l01"> 确认密码: <input id="repeat" name="repeat" type="password" placeholder="再次输入密码"></li>
    <li class="l01"> 电子邮箱: <input id="email" name="email" type="text" placeholder="请输入电子邮箱"
                                  value="${empty requestScope.email?"":requestScope.email}"></li>
    <li class="l01">验证码: <input id="code" name="code" type="text" placeholder="请输入验证码"></li>
        <li><img id="img"  src="kaptcha.jpg" height=50 width=200/></li>
    <li ><button class="login_b" type="submit" >注册</button></li>
        <li ><a style="font-family: 'Roboto'" href="pages/user/login.jsp">已有账户？点击登录</a></li>
    </form>
    <%@include file="/pages/common/footer.jsp"%>
</div>
</ul>
</body>
</html>