package publicwifi.publicwifi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiDao {

    public void clsDb() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        HistoryDb();

        String url = "jdbc:sqlite:identifier.sqlite";

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {


            stmt = con.createStatement();
            if (emptyCheck("row") != false) {
                String sql = " DROP TABLE row; ";
                stmt.executeUpdate(sql);
                con.commit();
                stmt = con.createStatement();
                sql = " create table row " +
                        " (" +
                        "    Count_NUM           INTEGER primary key autoincrement ," +
                        "    X_SWIFI_MGR_NO      TEXT, " +
                        "    X_SWIFI_WRDOFC      TEXT, " +
                        "    X_SWIFI_MAIN_NM     TEXT, " +
                        "    X_SWIFI_ADRES1      TEXT, " +
                        "    X_SWIFI_ADRES2      TEXT, " +
                        "    X_SWIFI_INSTL_FLOOR TEXT, " +
                        "    X_SWIFI_INSTL_TY    TEXT, " +
                        "    X_SWIFI_INSTL_MBY   TEXT, " +
                        "    X_SWIFI_SVC_SE      TEXT, " +
                        "    X_SWIFI_CMCWR       TEXT, " +
                        "    X_SWIFI_CNSTC_YEAR  TEXT, " +
                        "    X_SWIFI_INOUT_DOOR  TEXT, " +
                        "    X_SWIFI_REMARS3     TEXT, " +
                        "    LAT                 REAL not null, " +
                        "    LNT                 REAL not null, " +
                        "    WORK_DTTM           REAL " +
                        ") ; ";
                stmt.executeUpdate(sql);
                con.commit();

                rs = stmt.executeQuery(" SELECT * FROM row; ");

                rs.close();
                stmt.close();
                con.close();

            } else {
                String sql = "";
                con.commit();
                stmt = con.createStatement();
                sql = " create table row " +
                        " (" +
                        "    Count_NUM           INTEGER primary key autoincrement ," +
                        "    X_SWIFI_MGR_NO      TEXT, " +
                        "    X_SWIFI_WRDOFC      TEXT, " +
                        "    X_SWIFI_MAIN_NM     TEXT, " +
                        "    X_SWIFI_ADRES1      TEXT, " +
                        "    X_SWIFI_ADRES2      TEXT, " +
                        "    X_SWIFI_INSTL_FLOOR TEXT, " +
                        "    X_SWIFI_INSTL_TY    TEXT, " +
                        "    X_SWIFI_INSTL_MBY   TEXT, " +
                        "    X_SWIFI_SVC_SE      TEXT, " +
                        "    X_SWIFI_CMCWR       TEXT, " +
                        "    X_SWIFI_CNSTC_YEAR  TEXT, " +
                        "    X_SWIFI_INOUT_DOOR  TEXT, " +
                        "    X_SWIFI_REMARS3     TEXT, " +
                        "    LAT                 REAL not null, " +
                        "    LNT                 REAL not null, " +
                        "    WORK_DTTM           REAL " +
                        ") ; ";
                stmt.executeUpdate(sql);
                con.commit();

                rs = stmt.executeQuery(" SELECT * FROM row; ");

                rs.close();
                stmt.close();
                con.close();
                }
        } catch(SQLException e){
                e.printStackTrace();
        }

    }
    public void dataIn (WifiDto wifiLister){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                String sql = " INSERT INTO row (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) " +
                        " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";


                ps = con.prepareStatement(sql);
                ps.setString(1, wifiLister.getMgr_No());
                ps.setString(2, wifiLister.getCityName());
                ps.setString(3, wifiLister.getWifi_Name());
                ps.setString(4, wifiLister.getAdr1());
                ps.setString(5, wifiLister.getAdr2());
                ps.setString(6, wifiLister.getFloor());
                ps.setString(7, wifiLister.getInst_Tp());
                ps.setString(8, wifiLister.getInst_Org());
                ps.setString(9, wifiLister.getSvc_Se());
                ps.setString(10, wifiLister.getInternet_Tp());
                ps.setString(11, wifiLister.getInst_Yr());
                ps.setString(12, wifiLister.getInOut());
                ps.setString(13, wifiLister.getWifi_Env());
                ps.setString(14, wifiLister.getLat());
                ps.setString(15, wifiLister.getLnt());
                ps.setString(16, wifiLister.getWork_date());

                ps.executeUpdate();

//            if(affected > 0) {
//                System.out.println("저장 성공");
//            } else {
//                System.out.println("저장 실패");
//            }


                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public List<WifiDto> HistoryOut () {

            List<WifiDto> wifiListTmp = new ArrayList<>();

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                String sql = " select Count_NUM, LAT, LNT, VIEW_DATE" +
                        " FROM history order by Count_NUM desc ; ";

                ps = con.prepareStatement(sql);

                rs = ps.executeQuery();

                while (rs.next()) {
                    String CntNo = rs.getString("Count_NUM");
                    String Lat = rs.getString("LAT");
                    String Lnt = rs.getString("LNT");
                    String ViewDate = rs.getString("VIEW_DATE");


                    WifiDto tempWifiDto = new WifiDto();
                    tempWifiDto.setCnt_No(CntNo);
                    tempWifiDto.setLat(Lat);
                    tempWifiDto.setLnt(Lnt);
                    tempWifiDto.setView_Date(ViewDate);

                    wifiListTmp.add(tempWifiDto);
//          ===========결과 확인 print=======
//                System.out.println(X_SWIFI_MGR_NO + ", "
//                        +X_SWIFI_WRDOFC + ", "
//                        +X_SWIFI_MAIN_NM + ", "
//                        +X_SWIFI_ADRES1 + ", "
//                        +X_SWIFI_ADRES2 + ", "
//                        +X_SWIFI_INSTL_FLOOR + ", "
//                        +X_SWIFI_INSTL_TY + ", "
//                        +X_SWIFI_INSTL_MBY + ", "
//                        +X_SWIFI_SVC_SE + ", "
//                        +X_SWIFI_CMCWR + ", "
//                        +X_SWIFI_CNSTC_YEAR + ", "
//                        +X_SWIFI_INOUT_DOOR + ", "
//                        +X_SWIFI_REMARS3 + ", "
//                        +LAT + ", "
//                        +LNT + ", "
//                        +WORK_DTTM + ", ");
                }

                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return wifiListTmp;
        }

    public List<WifiDto> distanceGet (String lat, String lnt){

            List<WifiDto> wifiList = new ArrayList<>();

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            HistoryIn(lat, lnt);

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                String sql =
                        " SELECT " +
                                "   X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, " +
                                "   X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, " +
                                "   X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, " +
                                "   X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM, Count_NUM , ( " +
                                "        6371 * acos (cos (radians(?) ) " +
                                "         * cos (radians(LAT)) " +
                                "         * cos (radians(LNT) - radians(?) ) " +
                                "         + sin (radians(?)) * sin (radians( LAT ))) " +
                                "        ) AS distance " +
                                "    FROM row " +
                                "    GROUP BY distance  " +
                                "    HAVING count (distance) < 100 " +
                                "    ORDER BY distance " +
                                "    LIMIT 0 , 20;";


                ps = con.prepareStatement(sql);
                ps.setString(1, lat);
                ps.setString(2, lnt);
                ps.setString(3, lat);

                rs = ps.executeQuery();

                while (rs.next()) {
                    String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                    String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                    String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                    String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                    String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                    String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                    String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                    String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                    String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                    String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                    String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                    String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                    String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                    String LAT = rs.getString("LAT");
                    String LNT = rs.getString("LNT");
                    String WORK_DTTM = rs.getString("WORK_DTTM");
                    String Cnt_No = rs.getString("Count_Num");
                    String Distance = rs.getString("distance");

                    WifiDto tempWifiDto = new WifiDto();
                    tempWifiDto.setMgr_No(X_SWIFI_MGR_NO);
                    tempWifiDto.setCityName(X_SWIFI_WRDOFC);
                    tempWifiDto.setWifi_Name(X_SWIFI_MAIN_NM);
                    tempWifiDto.setAdr1(X_SWIFI_ADRES1);
                    tempWifiDto.setAdr2(X_SWIFI_ADRES2);
                    tempWifiDto.setFloor(X_SWIFI_INSTL_FLOOR);
                    tempWifiDto.setInst_Tp(X_SWIFI_INSTL_TY);
                    tempWifiDto.setInst_Org(X_SWIFI_INSTL_MBY);
                    tempWifiDto.setSvc_Se(X_SWIFI_SVC_SE);
                    tempWifiDto.setInternet_Tp(X_SWIFI_CMCWR);
                    tempWifiDto.setInst_Yr(X_SWIFI_CNSTC_YEAR);
                    tempWifiDto.setInOut(X_SWIFI_INOUT_DOOR);
                    tempWifiDto.setWifi_Env(X_SWIFI_REMARS3);
                    tempWifiDto.setLat(LAT);
                    tempWifiDto.setLnt(LNT);
                    tempWifiDto.setWork_date(WORK_DTTM);
                    tempWifiDto.setCnt_No(Cnt_No);
                    tempWifiDto.setDistance(Distance);

                    wifiList.add(tempWifiDto);
//
//                System.out.println(X_SWIFI_MGR_NO + ", "
//                        +X_SWIFI_WRDOFC + ", "
//                        +X_SWIFI_MAIN_NM + ", "
//                        +X_SWIFI_ADRES1 + ", "
//                        +X_SWIFI_ADRES2 + ", "
//                        +X_SWIFI_INSTL_FLOOR + ", "
//                        +X_SWIFI_INSTL_TY + ", "
//                        +X_SWIFI_INSTL_MBY + ", "
//                        +X_SWIFI_SVC_SE + ", "
//                        +X_SWIFI_CMCWR + ", "
//                        +X_SWIFI_CNSTC_YEAR + ", "
//                        +X_SWIFI_INOUT_DOOR + ", "
//                        +X_SWIFI_REMARS3 + ", "
//                        +LAT + ", "
//                        +LNT + ", "
//                        +WORK_DTTM + ", "
//                        +Cnt_No + ", "
//                        +Distance+ ", ");
                }

                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return wifiList;
        }
    public void HistoryDb () {

            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
                con.setAutoCommit(false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                stmt = con.createStatement();
                if (emptyCheck("history") != false) {
                    String sql = " DROP TABLE history; ";
                    stmt.executeUpdate(sql);
                    con.commit();
                    stmt = con.createStatement();
                    sql = " create table history " +
                            " (" +
                            "    Count_NUM           INTEGER primary key autoincrement ," +
                            "    LAT                 REAL not null, " +
                            "    LNT                 REAL not null, " +
                            "    VIEW_DATE           Timestamp default current_timestamp " +
                            ") ; ";
                    stmt.executeUpdate(sql);
                    con.commit();

                    rs = stmt.executeQuery(" SELECT * FROM history; ");

                    rs.close();
                    stmt.close();
                    con.close();
                } else {
                    String sql = "";
                    con.commit();
                    stmt = con.createStatement();
                    sql = " create table history " +
                            " (" +
                            "    Count_NUM           INTEGER primary key autoincrement ," +
                            "    LAT                 REAL not null, " +
                            "    LNT                 REAL not null, " +
                            "    VIEW_DATE           Timestamp default current_timestamp " +
                            ") ; ";
                    stmt.executeUpdate(sql);
                    con.commit();

                    rs = stmt.executeQuery(" SELECT * FROM history; ");

                    rs.close();
                    stmt.close();
                    con.close();
                }




            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    public static void HistoryIn (String lat, String lnt){
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                String sql = " INSERT INTO history (LAT, LNT) " +
                        " VALUES (?,?); ";


                ps = con.prepareStatement(sql);
                ps.setString(1, lat);
                ps.setString(2, lnt);

                ps.executeUpdate();


                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void HistoryDel (String a){

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                String sql = " DELETE FROM history  " +
                        " where Count_NUM = ? ; ";


                ps = con.prepareStatement(sql);
                ps.setString(1, a);

                ps.executeUpdate();


                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    public static void HistoryDelAll () {

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String url = "jdbc:sqlite:identifier.sqlite";

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {


                String sql = " DELETE FROM history ";


                ps = con.prepareStatement(sql);

                ps.executeUpdate();


                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    private boolean emptyCheck(String table) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url = "jdbc:sqlite:identifier.sqlite";

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int CntNoTmp = 0;
        try {


            String sql = " SELECT COUNT(*) FROM sqlite_master WHERE Name = ? ; ";

            ps = con.prepareStatement(sql);
            ps.setString(1, table);

            rs = ps.executeQuery();

            rs.next();
            String CntNo = rs.getString("COUNT(*)");
            CntNoTmp = Integer.parseInt(CntNo);
            System.out.println(CntNoTmp);


//                WifiDto tempWifiDto = new WifiDto();
//                tempWifiDto.setCnt_No(CntNo);
//                tempWifiDto.setLat(Lat);
//                tempWifiDto.setLnt(Lnt);
//                tempWifiDto.setView_Date(ViewDate);
//
//                wifiListTmp.add(tempWifiDto);
//          ===========결과 확인 print=======
//                System.out.println(X_SWIFI_MGR_NO + ", "
//                        +X_SWIFI_WRDOFC + ", "
//                        +X_SWIFI_MAIN_NM + ", "
//                        +X_SWIFI_ADRES1 + ", "
//                        +X_SWIFI_ADRES2 + ", "
//                        +X_SWIFI_INSTL_FLOOR + ", "
//                        +X_SWIFI_INSTL_TY + ", "
//                        +X_SWIFI_INSTL_MBY + ", "
//                        +X_SWIFI_SVC_SE + ", "
//                        +X_SWIFI_CMCWR + ", "
//                        +X_SWIFI_CNSTC_YEAR + ", "
//                        +X_SWIFI_INOUT_DOOR + ", "
//                        +X_SWIFI_REMARS3 + ", "
//                        +LAT + ", "
//                        +LNT + ", "
//                        +WORK_DTTM + ", ");
//            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (CntNoTmp > 0) {
            return true;
        } else {
            return false;
        }
    }
}

