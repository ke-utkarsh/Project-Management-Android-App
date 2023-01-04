package com.example.projectteam.model;

public class ProjectModel {
    private int pid;
    private String pname;
    private String sdate;
    private String edate;
    private String pdes;
    private String tname;


    public ProjectModel(int pid, String pname, String sdate, String edate, String pdes, String tname) {
        this.pid = pid;
        this.pname = pname;
        this.sdate = sdate;
        this.edate = edate;
        this.pdes = pdes;
        this.tname = tname;
    }

    public String getPid() {
        return Integer.toString(pid);
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getPdes() {
        return pdes;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
