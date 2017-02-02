package com.frank.entity;

public class Student {
    private Integer sId;

    private String sName;

    private Integer firstWish;

    private Integer secondWish;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Integer getFirstWish() {
        return firstWish;
    }

    public void setFirstWish(Integer firstWish) {
        this.firstWish = firstWish;
    }

    public Integer getSecondWish() {
        return secondWish;
    }

    public void setSecondWish(Integer secondWish) {
        this.secondWish = secondWish;
    }
}