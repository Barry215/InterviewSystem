package com.frank.service;

import com.frank.entity.Record;
import com.frank.entity.Student;

/**
 * Created by frank on 17/2/2.
 */
public interface InterviewService {
    Student getInterviewee(int section_id);

    void exportRecord(int section_id);

    boolean addRecord(Record record);

    void clearRecord();

    int getWaitNum(int section_id);

    void updateInterviewee(int section_id,int student_id);

    void beginInterview(int section_id);

    void skipInterview(int section_id);

    void doneInterview(int section_id,Record record);

    void freeSection(int section_id);
}
