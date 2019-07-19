<%--
  Created by IntelliJ IDEA.
  User: william chen
  Date: 2019/7/16
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updategoods" method="post" enctype="multipart/form-data" >
    <input type="hidden" name="goodsId" value="${goods.id}">
    <table>
        <tr>
            <td>商品名</td>
            <td><input type="text" value="${goods.name}" name="name"></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><img src="upload/${goods.pic}" width="50px" height="50px">
                <input type="file" name="pic">
                <input type="hidden" value="${goods.pic}" name="pics">
            </td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" value="${goods.price}" name="price"></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><input type="text" value="${goods.description}" name="description"></td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td><input type="text" value="${goods.stock}" name="stock"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
