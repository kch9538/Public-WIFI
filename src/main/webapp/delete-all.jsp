<%@ page import="publicwifi.publicwifi.WifiDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    WifiDao wifiDaoTmp = new WifiDao();
    wifiDaoTmp.HistoryDb(); %>
<script>
    alert('전체 데이터 삭제 성공');
    location.href = 'history.jsp'
</script>
</body>
</html>
