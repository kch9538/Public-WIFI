<%@ page import="publicwifi.publicwifi.WifiDao" %>
<%@ page import="publicwifi.publicwifi.WifiDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기-Hisroty</title>
    <script type="text/javascript">
        function historyDel(id) {
            if(confirm("정말 삭제하시겠습니까?")) {
                location.href = "delete.jsp?id=" + id;
            }
            return false;
        }
        function deleteAll() {
            if(confirm("정말 삭제하시겠습니까?")) {
                location.href = "delete-all.jsp";
            }
            return false;
        }
    </script>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    WifiDao wifiDao = new WifiDao();
    List<WifiDto> wifiDtoListTmp = wifiDao.HistoryOut();
%>
<h1>위치 히스토리 목록
</h1>
<h2>
    <a href="index.jsp">홈</a>
    <a> ㅣ</a>
    <a href="history.jsp">위치 히스토리 목록</a>
    <a> ㅣ</a>
    <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
    <a> ㅣ</a>
    <button onclick="deleteAll()">전체삭제</button>
</h2>
<br/>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>조회일자</th>
            <th>비고</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <% for (WifiDto wifiDto : wifiDtoListTmp) { %>
                    <tr>
                        <td><%=wifiDto.getCnt_No()%></td>
                        <td><%=wifiDto.getLat()%></td>
                        <td><%=wifiDto.getLnt()%></td>
                        <td><%=wifiDto.getView_Date()%></td>
                        <td><button onclick="historyDel('<%=wifiDto.getCnt_No() %>')">삭제</button></td>
            <%}%>
        </tr>

        </tbody>
    </table>
</body>
</html>