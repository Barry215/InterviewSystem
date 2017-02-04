package com.frank.service.impl;

import com.frank.dao.RecordMapper;
import com.frank.dao.SectionMapper;
import com.frank.dao.StudentMapper;
import com.frank.entity.Queue;
import com.frank.entity.Record;
import com.frank.entity.Section;
import com.frank.entity.Student;
import com.frank.service.InterviewService;
import com.frank.service.QueueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by frank on 17/2/2.
 */
@Service
public class InterviewServiceImpl implements InterviewService {

    @Resource
    private RecordMapper recordMapper;

    @Resource
    private SectionMapper sectionMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private QueueService queueService;

    @Override
    public Student getInterviewee(int section_id) {
        Section section = sectionMapper.selectByPrimaryKey(section_id);
        if (section.getState() != 0){
            return studentMapper.selectByPrimaryKey(section.getStudentId());
        }else {
            queueService.queueOut(section_id);
            return null;
        }
    }

    @Override
    public void exportRecord(int section_id) {

    }

    @Override
    public boolean addRecord(Record record) {
        return recordMapper.insertSelective(record) == 1;
    }

    @Override
    public void clearRecord() {
        recordMapper.clearRecord();
    }

    @Override
    public int getWaitNum(int section_id) {
        int waitNum = 0;

        switch (section_id){
            case 1:
                waitNum = Queue.queue_1.size();
                break;
            case 2:
                waitNum = Queue.queue_2.size();
                break;
            case 3:
                waitNum = Queue.queue_3.size();
                break;
            case 4:
                waitNum = Queue.queue_4.size();
                break;
            case 5:
                waitNum = Queue.queue_5.size();
                break;
            case 6:
                waitNum = Queue.queue_6.size();
                break;
        }
        return waitNum;
    }

    @Override
    public void updateInterviewee(int section_id, int student_id) {
        Section section = sectionMapper.selectByPrimaryKey(section_id);
        section.setState(1);
        section.setStudentId(student_id);
        sectionMapper.updateByPrimaryKey(section);
    }

    @Override
    public void beginInterview(int section_id) {
        Section section = sectionMapper.selectByPrimaryKey(section_id);
        section.setState(2);
        sectionMapper.updateByPrimaryKey(section);
    }

    @Override
    public void skipInterview(int section_id) {
        freeSection(section_id);
    }

    @Override
    public void doneInterview(Record record) {
        freeSection(record.getSectionId());
        addRecord(record);
    }

    @Override
    public void freeSection(int section_id) {
        Section section = sectionMapper.selectByPrimaryKey(section_id);
        section.setState(0);
        section.setStudentId(null);
        sectionMapper.updateByPrimaryKey(section);
    }
}
