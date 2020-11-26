<%--
  Created by IntelliJ IDEA.
  User: 非洲吴彦祖
  Date: 2020/10/9
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body class="manager_body">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

<form action="paperServlet/update"     >
    <input type="hidden" name="id" value="${requestScope.paper.id}">
    <input type="hidden" name="pageNo" value="${param.pageNo}">
    <div >
        <table class="pure-table pure-table-horizontal">
            <thead>
            <tr>
                <td align="center">名称</td>
                <td align="center">价格</td>
                <td align="center">作者</td>
                <td align="center">销量</td>
                <td align="center">库存</td>
                <td align="center">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td align="center"><input type="text" name="name" value="${requestScope.paper.name}" ></td>
                <td align="center"><input type="text" name="price"value=" ${requestScope.paper.price}" ></td>
                <td align="center"><input type="text" name="author" value="${requestScope.paper.author}"></td>
                <td align="center"><input type="text" name="sale" value="${requestScope.paper.sale}"></td>
                <td align="center"><input type="text" name="stock" value="${requestScope.paper.stock}"></td>
                <th align="center" ><button type="submit" style="background: transparent">提交</button></th>
            </tr>
            </tbody>
        </table>
    </div>
</form>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
