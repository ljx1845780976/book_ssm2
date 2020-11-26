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
                var i=confirm("确认删除?");
                if(i==true){
                    return true;
                }
                else if (i==false){
                    return  false;
                }
            })
        })
    </script>
</head>

<body class="manager_body">
<%@ include file="/pages/common/common.jsp"%>

<div id="table_div">
<table class="pure-table pure-table-horizontal">
    <thead>
    <tr>
        <td align="center">名称</td>
        <td align="center">价格</td>
        <td align="center">作者</td>
        <td align="center">销量</td>
        <td align="center">库存</td>
        <td colspan="2"></td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${requestScope.page.items}" var="paper">
    <tr>
        <td align="center">${paper.name}</td>
        <td align="center">${paper.price}</td>
        <td align="center">${paper.author}</td>
        <td align="center">${paper.sale}</td>
        <td align="center">${paper.stock}</td>
        <td align="center"><a href="paperServlet/show_init?id=${paper.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
        <td align="center"><a class="del" href="paperServlet/delete?id=${paper.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
    </tr>
    </c:forEach>

    </tbody>
</table>
    <br/>
    <%@include file="/pages/common/page.jsp"%>
</div>
<div style="text-align: center;"><a style="font-size: large" href="pages/manager/paper_add.jsp?pageTotal=${requestScope.page.pageTotal}">添加壁纸</a></div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
