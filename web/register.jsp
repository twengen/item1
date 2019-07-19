<%--
  Created by IntelliJ IDEA.
  User: william chen
  Date: 2019/7/15
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function check() {
            var username = document.getElementById("usen");
            var pass = document.getElementById("pass");
            var passdd = document.getElementById("passdd");
            var xingqu = document.getElementById("xingqu");
            var phone = document.getElementById("phone");
            var email = document.getElementById("email");
            var addrs = document.getElementById("addrs");
            if(!username.value){
                alert("用户名不能为空");
                return false;
            }
            if(!pass.value){
                alert("密码不能为空");
                return false;
            }if(!xingqu.value){
                alert("兴趣不能为空");
                return false;
            }if(!phone.value){
                alert("电话号码不能为空");
                return false;
            }if(!email.value){
                alert("不能为空");
                return false;
            }if(!addrs.value){
                alert("地址不能为空");
                return false;
            }if(!passdd.value){
                alert("再次输入的密码不能为空");
                return false;
            }
            if(pass.value!=passdd.value){
                alert("两次输入的密码不一致")
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="registerservlet" method="post" onsubmit="return check()">
    用户名：<input type="text" name="username" id="usen"><br/>
    密码：<input type="password" name="password" id="pass"><br/>
    再次输入密码：<input type="password" id="passdd"><br/>
    请选择性别；<input type="radio" name="sex" value="男">男<br/>&nbsp;<input type="radio" name="sex" value="女">女<br/>
    兴趣：<input type="text" name="xingqu" id="xingqu"><br/>
    电话号码：<input type="text" name="phone" id="phone"><br/>
    邮箱：<input type="text" name="email" id="email"><br/>
    address：<input type="text" name="addrs" id="addrs"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
