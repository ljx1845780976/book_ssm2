<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--
       设置动态base地址
 --%>
<%
      String basePath=request.getScheme()+"://"+request.getServerName()+":" +
              request.getServerPort()+request.getContextPath()+"/";
      pageContext.setAttribute("basePath",basePath);
%>

<base href="<%=basePath%>">
<link rel="stylesheet" href="statics/css/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="tool/jquery-3.5.1.js"></script>
