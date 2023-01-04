package com.example.projectteam.model;

public class GetAllBooksApiRequest {
    private String tname;

    public GetAllBooksApiRequest(String tname) {
        this.tname = tname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
