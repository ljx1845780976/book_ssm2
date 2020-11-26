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
    <script type="text/javascript">
        $(function () {
            $(".del").click(function () {
                var name=$(this).parent().parent().find("td:first").text();
               return confirm("确认删除"+name+"?");
            });
            $("#clear").click(function () {
                return confirm("确认清空收藏栏?");
            });
            $(".update").change(function () {
                var name=$(this).parent().parent().find("td:first").text();
                var count=this.value;
                 var id=$(this).attr("itemId");
                    if( confirm("确认修改"+name+"的数量为"+count+"?")){
                        //发起请求给服务器保存数据
                        location.href="${basePath}cartServlet/update?count="+count+"&id="+id;
                    }  //defaultValue表示初始值
                    else {
                         this.value=this.defaultValue;
                    }
            });
        })
    </script>
</head>

<body class="manager_body">
<%@ include file="/pages/common/common.jsp"%>
<input type="hidden" name="action" value="page">

<div id="table_div3">
    <table class="pure-table pure-table-horizontal">
        <thead>
        <tr>
            <td align="center">名称</td>
            <td align="center">数量</td>
            <td align="center">价格</td>
            <td align="center">总价格</td>
            <td colspan="2"></td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${sessionScope.cart.items}" var="cartItem">
            <tr>
                <td align="center">${cartItem.value.name}</td>
                <td align="center">
                    <input class="update" type="text" itemId="${cartItem.value.id}" value="${cartItem.value.count}" />
                </td>
                <td align="center">${cartItem.value.price}</td>
                <td align="center">${cartItem.value.totalPrice}</td>
                <td align="center"><a class="del" href="cartServlet/deleteItem?id=${cartItem.value.id}">删除</a></td>
            </tr>
        </c:forEach>
        <c:if test="${ empty sessionScope.cart.items}">
            <tr>
                <td colspan="5" align="center">当前收藏栏为空，快去收藏自己喜欢的壁纸把！</td>
            </tr>
        </c:if>
        </tbody>

    </table>
</div>

<c:if test="${not empty sessionScope.cart.items}">
    <div id="cart" align="center">
        <span >收藏栏中共有<span class="collect_span">${sessionScope.cart.totalCount}</span>件商品</span>
        <span>总金额为<span class="collect_span">${sessionScope.cart.totalPrice}</span>元</span>
        <br/>
       <span><a id="clear" href="cartServlet/clear ">清空</a></span>
        <span><a href="orderServlet/createOrder">下载</a></span>
    </div>
</c:if>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
