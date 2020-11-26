<%--
  Created by IntelliJ IDEA.
  User: 非洲吴彦祖
  Date: 2020/10/8
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>ForestAtNight</title>
    <%@include file="/pages/common/head.jsp"%>
</head>

<body class="manager_body">
<%@ include file="/pages/common/common.jsp"%>
<input type="hidden" name="action" value="page">
<br/>
<br/>
<br/>
<div align="center" id="table_div3">
    你的订单已结算，订单号为：${sessionScope.orderId}
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
