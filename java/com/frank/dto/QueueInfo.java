package com.frank.dto;

import com.frank.entity.Section;
import com.frank.entity.Student;

import java.util.List;

/**
 * Created by frank on 17/2/3.
 */
public class QueueInfo {
    private String stu_name;
    private int sec_state;
    private List<String> queueList;

    public QueueInfo(String stu_name, int sec_state, List<String> queueList) {
        this.stu_name = stu_name;
        this.sec_state = sec_state;
        this.queueList = queueList;
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

    public List<String> getQueueList() {
        return queueList;
    }

    public void setQueueList(List<String> queueList) {
        this.queueList = queueList;
    }
}
