package com.example.pmisinfo;

public class progress {
    String ProjectName,UPC,RO,PMU,date;
    int km,pmis_id;

    public progress(String projectName, String UPC,int pmis_id, String RO, String PMU) {
        this.ProjectName = projectName;
        this.UPC = UPC;
        this.RO = RO;
        this.PMU = PMU;
        this.pmis_id=pmis_id;
        this.km=0;
        this.date="";
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }
/*
    public String getPMIS() {
        return PMIS;
    }

    public void setPMIS(String PMIS) {
        this.PMIS = PMIS;
    }*/

    public String getRO() {
        return RO;
    }

    public void setRO(String RO) {
        this.RO = RO;
    }

    public String getPMU() {
        return PMU;
    }

    public void setPMU(String PMU) {
        this.PMU = PMU;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPmis_id() {
        return pmis_id;
    }

    public void setPmis_id(int pmis_id) {
        this.pmis_id = pmis_id;
    }
}
