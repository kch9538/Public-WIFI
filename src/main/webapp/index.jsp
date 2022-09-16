<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>와이파이 정보 구하기</title>
</head>
<body>
<script = "javascript">
    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                document.getElementById("lat").value = position.coords.latitude;
                document.getElementById("lnt").value = position.coords.longitude;
            }, function(error) {
                console.error(error);
            }, {
                enableHighAccuracy: false,
                maximumAge: 0,
                timeout: Infinity
            });
        } else {
            alert('현재환경은 위치정보를 지원하지 않습니다');
        }
    }
</script>
<h1>와이파이 정보 구하기
</h1>
<h2>
    <a href="index.jsp">홈</a>
    <a> ㅣ</a>
    <a href="history.jsp">위치 히스토리 목록</a>
    <a> ㅣ</a>
    <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</h2>
    <form action="index.jsp" method="post">
        <h3> LNT : </h3>
        <input type= "text" id="lnt" name="lnt">
        <h3> LAT : </h3>
        <input type= "text" id="lat" name="lat">
        <input type="button" onclick = getLocation() value="내 위치 가져오기">
    <form action="wifi-list.jsp" method="get">
        <input type="button" id="load" onclick="
        fetch('wifi-list.jsp?lat='+document.getElementById('lat').value +'&lnt='+document.getElementById('lnt').value
            )
            .then(function (response) {
            response.text().then(function (text){
                document.querySelector('tbody').innerHTML = text;
            })
        })"  value="근처 WIFI 정보 보기">

    </form>


    <table>
        <thead>
            <tr>
                <th>거리(Km)</th>
                <th>관리번호</th>
                <th>자치구</th>
                <th>와이파이명</th>
                <th>도로명주소</th>
                <th>상세주소</th>
                <th>설치위치(층)</th>
                <th>설치유형</th>
                <th>설치기관</th>
                <th>서비스구분</th>
                <th>망종류</th>
                <th>설치년도</th>
                <th>실내외구분</th>
                <th>WIFI접속환경</th>
                <th>X좌표</th>
                <th>Y좌표</th>
                <th>작업일자</th>
            </tr>
        </thead>
        <tbody>
        <tr>
            <td colspan="17"> 위치 정보를 입력한 후에 조회해 주세요.
            </td>
        </tr>
        </tbody>
    </table>
</body>
</html>