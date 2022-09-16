<%@ page import="publicwifi.publicwifi.WifiDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String a = request.getParameter("id");
    WifiDao wifiDao =new WifiDao();
    wifiDao.HistoryDel(a);
%>
<script>
    alert('<%=a%>번 데이터 삭제 성공');
    location.href = 'history.jsp';
</script>
</body>
</html>
