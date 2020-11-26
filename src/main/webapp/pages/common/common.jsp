<%--
  Created by IntelliJ IDEA.
  User: 非洲吴彦祖
  Date: 2020/10/7
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h1>FOREST AT NIGHT</h1>
<div align="right">
    <span style="font-family: 'Roboto';font-size: medium">当前账号：${sessionScope.username}</span>
    <a class="c02" href="pages/cart/cart.jsp">收藏</a>
    <a class="c02" href="paperServlet/page">管理</a>
    <a class="c02" href="userServlet/loginOut">注销</a>
    <a class="c02" href="pages/user/login_success.jsp">返回</a>
</div>

