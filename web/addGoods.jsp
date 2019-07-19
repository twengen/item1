<%--
  Created by IntelliJ IDEA.
  User: william chen
  Date: 2019/7/17
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addGoodsservlet" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>商品名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><input type="file" name="pic"></td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>商品描述：</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>商品库存：</td>
            <td><input type="text" name="stock"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="保存"></td>
        </tr>
    </table>
</form>

</body>
</html>
