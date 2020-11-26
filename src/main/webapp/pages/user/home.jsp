<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ForestAtNight</title>
    <%--静态包含base标签，css样式和jqurey标签--%>
   <%@  include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
           $(".collect").click(function () {

                     var paperId=$(this).attr("paperId");
                     var username="${sessionScope.username}";
                   if (username==null || username==""){
                       alert("请先登录！");return false;
                   }
                   $.getJSON("cartServlet/addItem?","id="+paperId,function (data) {
                        $(".notice").text(data.lastItem+"收藏成功");
                   });
               alert("添加成功！");
           });

        });

    </script>

</head>
<body id="login_body">
           <%--静态包含公共选项--%>
           <%@ include file="/pages/common/common.jsp"%>
           <div id="table_div2">
               <table >
                   <tr>
                   <c:forEach items="${requestScope.page.items}" var="paper">
                       <td>
                       <div class="p_list">
                           <ul class="paper_info">
                               <li class="p_items"> <img class="paper_img" alt="" src="${paper.img_path}"></li>
                               <li class="p_items">壁纸:${paper.name}</li>
                               <li class="p_items">价格:${paper.price}</li>
                               <li class="p_items">作者:${paper.author}</li>
                               <li class="p_items">收藏量:${paper.sale}</li>
                               <li class="p_items">下载量:${paper.stock}</li>
                               <li class="p_items"><a paperId="${paper.id}" class="collect" >添加到收藏</a></li>
                           </ul>
                       </div>
                       </td>
                   </c:forEach>
                   </tr>
               </table>

               <div id="s_by_price">
                   <form action="clientPaperServlet/pageByPrice">
               价格:<input name="min" type="text" value="${param.min}"/>元&nbsp—&nbsp<input name="max" type="text" value="${param.max}"/>元
               <button type="submit">查询</button>
                   </form>
               </div>
               <%@include file="/pages/common/page.jsp"%>
           </div>

           <%@ include file="/pages/common/footer.jsp"%>
           <c:if test="${empty sessionScope.cart.items}">
               <span  class="notice">购物车为空</span>
           </c:if>
           <c:if test="${not empty sessionScope.cart.items}">
               <span class="notice">${sessionScope.lastItem}收藏成功</span>
           </c:if>
</body>
</html>