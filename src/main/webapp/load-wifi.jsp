<%@ page import="publicwifi.publicwifi.ApiLoader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<style> body{
    font-size: 40px;
    font-weight: bold;
    width: 100%;
    text-align: center;
}</style>
    <title>Title</title>
</head>
<body>
    <h1><% ApiLoader dataGet = new ApiLoader(); %>
    <h1> <%=dataGet.apiGet()%>
        개의 데이터가 로드 되었습니다.<br></h1>
    <a href="index.jsp">메인페이지로 이동</a>
</body>
</html>
