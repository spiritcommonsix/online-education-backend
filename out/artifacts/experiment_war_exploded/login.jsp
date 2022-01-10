<%--
  Created by IntelliJ IDEA.
  User: Cheng
  Date: 2021/11/18
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="LoginServlet" method="post">
        <span>用户名：</span><input name="userName" placeholder="输入用户名">
        <br>
        <span>密码：</span><input type="password" name="password" placeholder="输入密码">
        <input type="submit" value="登录">
    </form>
</body>
</html>
