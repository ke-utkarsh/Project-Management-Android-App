package com.example.projectteam.model;

public class LoginModel {
    private String eid;
    private String password;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginModel(String eid, String password) {
        this.eid = eid;
        this.password = password;
    }
}
