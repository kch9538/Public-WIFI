<%@ page import="publicwifi.publicwifi.ApiLoader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
    <% ApiLoader dataGet = new ApiLoader(); %>
    <%=dataGet.apiGet()%>
    <a> 개의 데이터가 로드 되었습니다.</a><br>
    <a href="index.jsp">메인페이지로 이동</a>
</body>
</html>
