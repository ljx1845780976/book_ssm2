<%--
  Created by IntelliJ IDEA.
  User: 非洲吴彦祖
  Date: 2020/10/12
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="page">
    <c:if test="${requestScope.page.pageNo-1>0}">
        <a href="${requestScope.page.url}pageNo=1">首页 </a>
        <a href="${requestScope.page.url}pageNo=${requestScope.page.pageNo-1}">上一页 </a>
    </c:if>

    <c:choose>
        <%--一、页面总数小于5时--%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}" />
        </c:when>
        <%--二、页面总数大于5时--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--二.1、当前页面不大于3时--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5" />
                </c:when>
                <%--二.2、当前页面大于3小于总数-4时--%>
                <c:when test="${requestScope.page.pageNo>3 && requestScope.page.pageNo<requestScope.page.pageTotal-4}">
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}" />
                </c:when>
                <%--二.3、当前页面不小于总数-4时--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}" />
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i==requestScope.page.pageNo}" >
            【${i}】
        </c:if>
        <c:if test="${i!=requestScope.page.pageNo}">
            <a href="${requestScope.page.url}pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo+1<=requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <button id="page_b" type="submit">确定</button>
    <script type="text/javascript" >
        $(function () {
            $("#page_b").click(function () {
                var pageNo=$("#pn_input").val();

                // javascript语言提供有一个location地址栏d对象，其中的href属性可以获取地址栏的地址
                location.href="${pageScope.basePath}${requestScope.page.url}pageNo="
                    +pageNo;

            })
        })
    </script>
</div>