package publicwifi.publicwifi;

import lombok.ToString;

import java.text.DecimalFormat;

@ToString
public class WifiDto {
    private String Mgr_No;
    private String CityName;
    private String Wifi_Name;
    private String Adr1;
    private String Adr2;
    private String Floor;
    private String Inst_Tp;
    private String inst_Org;
    private String Svc_Se;
    private String Internet_Tp;
    private String Inst_Yr;
    private String InOut;
    private String Wifi_Env;
    private String Lat;
    private String Lnt;
    private String Work_date;
    private String Cnt_No;

    public String getView_Date() {
        return View_Date;
    }

    public void setView_Date(String view_Date) {
        View_Date = view_Date;
    }

    private String View_Date;

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    private String Distance;

    public String getCnt_No() {
        return Cnt_No;
    }

    public void setCnt_No(String cnt_No) {
        Cnt_No = cnt_No;
    }


    public String getMgr_No() {
        return Mgr_No;
    }

    public void setMgr_No(String mgr_No) {
        this.Mgr_No = mgr_No;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        this.CityName = cityName;
    }

    public String getWifi_Name() {
        return Wifi_Name;
    }

    public void setWifi_Name(String wifi_Name) {
        this.Wifi_Name = wifi_Name;
    }

    public String getAdr1() {
        return Adr1;
    }

    public void setAdr1(String adr1) {
        this.Adr1 = adr1;
    }

    public String getAdr2() {
        return Adr2;
    }

    public void setAdr2(String adr2) {
        this.Adr2 = adr2;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        this.Floor = floor;
    }

    public String getInst_Tp() {
        return Inst_Tp;
    }

    public void setInst_Tp(String inst_Tp) {
        this.Inst_Tp = inst_Tp;
    }

    public String getInst_Org() {
        return inst_Org;
    }

    public void setInst_Org(String inst_Org) {
        this.inst_Org = inst_Org;
    }

    public String getSvc_Se() {
        return Svc_Se;
    }

    public void setSvc_Se(String svc_Se) {
        this.Svc_Se = svc_Se;
    }

    public String getInternet_Tp() {
        return Internet_Tp;
    }

    public void setInternet_Tp(String internet_Tp) {
        this.Internet_Tp = internet_Tp;
    }

    public String getInst_Yr() {
        return Inst_Yr;
    }

    public void setInst_Yr(String inst_Yr) {
        this.Inst_Yr = inst_Yr;
    }

    public String getInOut() {
        return InOut;
    }

    public void setInOut(String inOut) {
        this.InOut = inOut;
    }

    public String getWifi_Env() {
        return Wifi_Env;
    }

    public void setWifi_Env(String wifi_Env) {
        this.Wifi_Env = wifi_Env;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        this.Lat = lat;
    }

    public String getLnt() {
        return Lnt;
    }

    public void setLnt(String lnt) {
        this.Lnt = lnt;
    }

    public String getWork_date() {
        return Work_date;
    }

    public void setWork_date(String work_date) {
        this.Work_date = work_date;
    }

}
