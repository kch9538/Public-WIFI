package publicwifi.publicwifi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiLoader {

//  API 호출을 위한 메서드

    public static String apiGetter(Integer startNum, Integer endNum) {
        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088")
                    .append("/" + URLEncoder.encode("67444664676368393830736852694c", "UTF-8"))
                    .append("/" + URLEncoder.encode("json", "UTF-8"))
                    .append("/" + URLEncoder.encode("TbPublicWifiInfo", "UTF-8"))
                    .append("/" + URLEncoder.encode(String.valueOf(startNum), "UTF-8"))
                    .append("/" + URLEncoder.encode(String.valueOf(endNum), "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");
            BufferedReader rd;

            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String result = bf.readLine();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

// 총 WIFI 갯수 구한 후 호출하는 메서드

    public static String apiGet() {

        WifiDao reset = new WifiDao();
        reset.clsDb();
        String amnt;
        int varStartNum = 1;

        try {

            String wifiInfo = apiGetter(varStartNum, varStartNum);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(wifiInfo);
            JSONObject list1 = (JSONObject) jsonObject.get("TbPublicWifiInfo");
            long amount = (long) list1.get("list_total_count");
            amnt = String.valueOf(amount);

            for (int i = 0; i < amount; i += 1000) {
                wifiInfo = apiGetter(i, i + 999);
                jsonObject = (JSONObject) jsonParser.parse(wifiInfo);
                list1 = (JSONObject) jsonObject.get("TbPublicWifiInfo");
                JSONArray list2 = (JSONArray) list1.get("row");
                for (int j = 0; j < list2.size(); j++) {
                    JSONObject wifiListFinal = (JSONObject) list2.get(j);
                    WifiDto wl = new WifiDto();
                    wl.setMgr_No((String) wifiListFinal.get("X_SWIFI_MGR_NO"));
                    wl.setCityName((String) wifiListFinal.get("X_SWIFI_WRDOFC"));
                    wl.setWifi_Name((String) wifiListFinal.get("X_SWIFI_MAIN_NM"));
                    wl.setAdr1((String) wifiListFinal.get("X_SWIFI_ADRES1"));
                    wl.setAdr2((String) wifiListFinal.get("X_SWIFI_ADRES2"));
                    wl.setFloor((String) wifiListFinal.get("X_SWIFI_INSTL_FLOOR"));
                    wl.setInst_Tp((String) wifiListFinal.get("X_SWIFI_INSTL_TY"));
                    wl.setInst_Org((String) wifiListFinal.get("X_SWIFI_INSTL_MBY"));
                    wl.setSvc_Se((String) wifiListFinal.get("X_SWIFI_SVC_SE"));
                    wl.setInternet_Tp((String) wifiListFinal.get("X_SWIFI_CMCWR"));
                    wl.setInst_Yr((String) wifiListFinal.get("X_SWIFI_CNSTC_YEAR"));
                    wl.setInOut((String) wifiListFinal.get("X_SWIFI_INOUT_DOOR"));
                    wl.setWifi_Env((String) wifiListFinal.get("X_SWIFI_REMARS3"));
                    wl.setLat((String) wifiListFinal.get("LAT"));
                    wl.setLnt((String) wifiListFinal.get("LNT"));
                    wl.setWork_date((String) wifiListFinal.get("WORK_DTTM"));

                    WifiDao dataManage = new WifiDao();
                    dataManage.dataIn(wl);
                }
            }

        } catch(ParseException e){
            throw new RuntimeException(e);
        }

        return amnt;
    }

}


