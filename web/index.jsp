<%--
  Created by IntelliJ IDEA.
  User: william chen
  Date: 2019/7/15
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
        // 验证输入不为空的脚本代码
        function onCheck() {
            var loginName = document.getElementById("loginName");
            var passw = document.getElementById("pasd");
            if(!loginName.value){
                alert("用户名不能为空");
                return false;
            }
            if(!passw.value){
                alert("密码不能为空")
                return false;
            }
            return true;
        }

        function onRegister() {
                window.location.href = "http://localhost:8080/register.jsp";
        }

    </script>
  </head>
  <body>
  <form action="verification" method="post" onsubmit="return onCheck()">
    username:<input type="text" name="username" id="loginName"><br/>
    password:<input type="password" name="password" id="pasd"><br/>
    <input type="submit" value="登陆" >&nbsp;
    <input type="button" value="注册" onclick="onRegister()">
  </form>
  </body>
</html>
