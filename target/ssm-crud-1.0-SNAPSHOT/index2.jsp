<%--
  Created by IntelliJ IDEA.
  User: zhukangle
  Date: 2020/10/26
  Time: 8:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:forward page="/emps"></jsp:forward>
<html>
<head>
    <title>Title</title>
    <%--    引入jquery--%>
    <script type="text/javascript"
            src="${APP_PATH }/static/js/jquery.min.js"></script>
    <link
            href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<button class="btn btn-success">按钮</button>
</body>
</html>
