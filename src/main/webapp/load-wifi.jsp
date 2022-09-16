<%@ page import="publicwifi.publicwifi.ApiLoader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<style> h1{
    font-size: 30px;
    font-weight: bold;
    width: 100%;
    text-align: center;
}</style>
    <title>Title</title>
</head>
<body>
<br>
    <h1><% ApiLoader dataGet = new ApiLoader(); %>
    <h1> <%=dataGet.apiGet()%>
        개의 WIFI 정보를 정상적으로 저장하였습니다.<br><br>
        <input type="button" onclick="location.href ='index.jsp'" value="메인페이지로 이동">
    </h1>
</body>
</html>
