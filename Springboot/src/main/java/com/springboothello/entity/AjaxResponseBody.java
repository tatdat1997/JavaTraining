package com.springboothello.entity;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<Student> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Student> getResult() {
        return result;
    }

    public void setResult(List<Student> result) {
        this.result = result;
    }

}
