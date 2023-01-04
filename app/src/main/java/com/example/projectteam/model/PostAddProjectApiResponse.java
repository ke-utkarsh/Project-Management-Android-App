package com.example.projectteam.model;

public class PostAddProjectApiResponse {

    private boolean record_created;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isRecord_created() {
        return record_created;
    }

    public void setRecord_created(boolean record_created) {
        this.record_created = record_created;
    }

    public PostAddProjectApiResponse(boolean record_created,String msg) {
        this.record_created = record_created;
        this.msg=msg;
    }
}
