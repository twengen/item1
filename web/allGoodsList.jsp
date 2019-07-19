<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: william chen
  Date: 2019/7/15
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function onUpdateUrl(goodsId) {
            //window.location.href = "stu_update.jsp?stuNo="+stuNo;
            window.location.href = "goodsloadservlet?goodsId="+goodsId;
        }
        function dele(goodsId) {
            window.location.href = "goodsdel?goodsId="+goodsId;
        }
        function addGoods() {
            window.location.href = "addGoods.jsp"
        }
    </script>
</head>
<body>
<table border="1" >
    <caption>商品列表</caption>

    <tr>
        <th>商品名</th>
        <th>图片</th>
        <th>价格</th>
        <th>库存</th>
        <th>商品详情</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${list}" var="good" varStatus="s">
        <tr>
            <td>${good.name}</td>
            <td><img src="upload/${good.pic}" width="50px" height="50px"/></td>
            <td>${good.price}</td>
            <td>${good.stock}</td>
            <td>${good.description}</td>
            <td><input type="button" onclick="onUpdateUrl(${good.id})" value="编辑">&nbsp;<input type="button" onclick="dele(${good.id})" value="删除"></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6"><input type="button" value="添加商品" onclick="addGoods()"></td>
    </tr>
</table>
</body>
</html>
