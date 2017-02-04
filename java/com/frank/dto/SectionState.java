package com.frank.dto;

/**
 * Created by frank on 17/2/3.
 */
public class SectionState {
    private String stu_name;
    private int sec_state;

    public SectionState(String stu_name, int sec_state) {
        this.stu_name = stu_name;
        this.sec_state = sec_state;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getSec_state() {
        return sec_state;
    }

    public void setSec_state(int sec_state) {
        this.sec_state = sec_state;
    }
}
