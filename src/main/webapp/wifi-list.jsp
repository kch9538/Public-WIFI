<%@ page import="publicwifi.publicwifi.WifiDao" %>
<%@ page import="publicwifi.publicwifi.WifiDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>WIFI LIST</title>
  <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
  String lan = request.getParameter("lat");
  String lnt = request.getParameter("lnt");
  WifiDao wifiDao = new WifiDao();
  List<WifiDto> wifiDtoList = wifiDao.distanceGet(lan,lnt);
%>
<table>
  <thead>
  <tr>
  </tr>
  </thead>
<tbody>
</tr>
  <%
    for (WifiDto wifiDto : wifiDtoList) {
      DecimalFormat format = new DecimalFormat("0.0000");
      double distance = Double.parseDouble(wifiDto.getDistance());
      out.write("<tr>");
      out.write("<td>"+format.format(distance) + "</td>");
      out.write("<td>"+wifiDto.getMgr_No() + "</td>");
      out.write("<td>"+wifiDto.getCityName() + "</td>");
      out.write("<td>"+wifiDto.getWifi_Name() + "</td>");
      out.write("<td>"+wifiDto.getAdr1() + "</td>");
      out.write("<td>"+wifiDto.getAdr2() + "</td>");
      out.write("<td>"+wifiDto.getFloor() + "</td>");
      out.write("<td>"+wifiDto.getInst_Tp() + "</td>");
      out.write("<td>"+wifiDto.getInst_Org() + "</td>");
      out.write("<td>"+wifiDto.getSvc_Se() + "</td>");
      out.write("<td>"+wifiDto.getInternet_Tp() + "</td>");
      out.write("<td>"+wifiDto.getInst_Yr() + "</td>");
      out.write("<td>"+wifiDto.getInOut() + "</td>");
      out.write("<td>"+wifiDto.getWifi_Env() + "</td>");
      out.write("<td>"+wifiDto.getLat()+ "</td>");
      out.write("<td>"+wifiDto.getLnt()+ "</td>");
      out.write("<td>"+wifiDto.getWork_date() + "</td>");
      out.write("<tr>");
    }
  %>
</tr>
</tbody>
</table>
</body>
</html>

