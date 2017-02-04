package com.frank.service;

import com.frank.entity.Record;
import com.frank.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

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

    void doneInterview(Record record);

    void freeSection(int section_id);

    List<Record> getSectionRecords(int section_id);

    HSSFWorkbook createExcel(int section_id);
}
