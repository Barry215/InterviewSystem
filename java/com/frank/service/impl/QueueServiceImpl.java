package com.frank.service.impl;

import com.frank.dao.SectionMapper;
import com.frank.dao.StudentMapper;
import com.frank.dto.QueueInfo;
import com.frank.dto.SectionState;
import com.frank.entity.Queue;
import com.frank.entity.Section;
import com.frank.entity.Student;
import com.frank.service.InterviewService;
import com.frank.service.QueueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 17/2/2.
 */
@Service
public class QueueServiceImpl implements QueueService {

    @Resource
    private InterviewService interviewService;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private SectionMapper sectionMapper;

    @Override
    public void queueIn(int QueueName, Student student) {
        switch (QueueName){
            case 1:
                Queue.queue_1.add(student);
                break;
            case 2:
                Queue.queue_2.add(student);
                break;
            case 3:
                Queue.queue_3.add(student);
                break;
            case 4:
                Queue.queue_4.add(student);
                break;
            case 5:
                Queue.queue_5.add(student);
                break;
            case 6:
                Queue.queue_6.add(student);
                break;
        }
    }

    @Override
    public void queueOut(int QueueName) {
        switch (QueueName){
            case 1:
                if (Queue.queue_1.size() > 0) {
                    interviewService.updateInterviewee(QueueName, Queue.queue_1.get(0).getsId());
                    Queue.queue_1.remove(0);
                }
                break;
            case 2:
                if (Queue.queue_2.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_2.get(0).getsId());
                    Queue.queue_2.remove(0);
                }
                break;
            case 3:
                if (Queue.queue_3.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_3.get(0).getsId());
                    Queue.queue_3.remove(0);
                }
                break;
            case 4:
                if (Queue.queue_4.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_4.get(0).getsId());
                    Queue.queue_4.remove(0);
                }
                break;
            case 5:
                if (Queue.queue_5.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_5.get(0).getsId());
                    Queue.queue_5.remove(0);
                }
                break;
            case 6:
                if (Queue.queue_6.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_6.get(0).getsId());
                    Queue.queue_6.remove(0);
                }
                break;
        }
    }

    @Override
    public void remove(int QueueName, int index) {
        switch (QueueName){
            case 1:
                Queue.queue_1.remove(index);
                break;
            case 2:
                Queue.queue_2.remove(index);
                break;
            case 3:
                Queue.queue_3.remove(index);
                break;
            case 4:
                Queue.queue_4.remove(index);
                break;
            case 5:
                Queue.queue_5.remove(index);
                break;
            case 6:
                Queue.queue_6.remove(index);
                break;
        }
    }

    @Override
    public void stick(int QueueName, int index) {
        switch (QueueName){
            case 1:
                Student student_1 = Queue.queue_1.get(index);
                Queue.queue_1.remove(index);
                Queue.queue_1.add(0,student_1);
                break;
            case 2:
                Student student_2 = Queue.queue_2.get(index);
                Queue.queue_2.remove(index);
                Queue.queue_2.add(0,student_2);
                break;
            case 3:
                Student student_3 = Queue.queue_3.get(index);
                Queue.queue_3.remove(index);
                Queue.queue_3.add(0,student_3);
                break;
            case 4:
                Student student_4 = Queue.queue_4.get(index);
                Queue.queue_4.remove(index);
                Queue.queue_4.add(0,student_4);
                break;
            case 5:
                Student student_5 = Queue.queue_5.get(index);
                Queue.queue_5.remove(index);
                Queue.queue_5.add(0,student_5);
                break;
            case 6:
                Student student_6 = Queue.queue_6.get(index);
                Queue.queue_6.remove(index);
                Queue.queue_6.add(0,student_6);
                break;
        }
    }

    @Override
    public void clearAllQueue() {
        Queue.queue_1.clear();
        Queue.queue_2.clear();
        Queue.queue_3.clear();
        Queue.queue_4.clear();
        Queue.queue_5.clear();
        Queue.queue_6.clear();
    }

    @Override
    public boolean isEmpty(int QueueName) {
        return interviewService.getWaitNum(QueueName) == 0;
    }

    @Override
    public boolean addStudent(Student student) {
        if (studentMapper.selectByPrimaryKey(student.getsId()) == null){
            return studentMapper.insertSelective(student) == 1;
        }else {
            return false;
        }
    }

    @Override
    public List<SectionState> getSectionState() {
        List<SectionState> sectionStates = new ArrayList<>();
        for (int i = 1; i<=6 ; i++){
            Section section = sectionMapper.selectByPrimaryKey(i);
            String stu_name = "";
            if (section.getStudentId() != null) {
                stu_name = studentMapper.selectByPrimaryKey(section.getStudentId()).getsName();
            }
            SectionState sectionState = new SectionState(stu_name,section.getState());
            sectionStates.add(sectionState);
        }
        return sectionStates;
    }

    @Override
    public List<QueueInfo> getQueueInfoList() {
        List<QueueInfo> queueInfoList = new ArrayList<>();

        for (int i = 1;i<=6;i++){
            Section section = sectionMapper.selectByPrimaryKey(i);
            String stu_name = "";
            if (section.getStudentId() != null){
                stu_name = studentMapper.selectByPrimaryKey(section.getStudentId()).getsName();
            }
            int sec_state = section.getState();
            List<String> QueueList = transferQueue(i);
            queueInfoList.add(new QueueInfo(stu_name,sec_state,QueueList));
        }
        return queueInfoList;
    }

    public List<String> transferQueue(int QueueName){
        List<String> QueueList = new ArrayList<>();
        switch (QueueName){
            case 1:
                if (Queue.queue_1.size()>0){
                    for (Student student : Queue.queue_1){
                        QueueList.add(student.getsName());
                    }
                }
                break;
            case 2:
                if (Queue.queue_2.size()>0){
                    for (Student student : Queue.queue_2){
                        QueueList.add(student.getsName());
                    }
                }
                break;
            case 3:
                if (Queue.queue_3.size()>0){
                    for (Student student : Queue.queue_3){
                        QueueList.add(student.getsName());
                    }
                }
                break;
            case 4:
                if (Queue.queue_4.size()>0){
                    for (Student student : Queue.queue_4){
                        QueueList.add(student.getsName());
                    }
                }
                break;
            case 5:
                if (Queue.queue_5.size()>0){
                    for (Student student : Queue.queue_5){
                        QueueList.add(student.getsName());
                    }
                }
                break;
            case 6:
                if (Queue.queue_6.size()>0){
                    for (Student student : Queue.queue_6){
                        QueueList.add(student.getsName());
                    }
                }
                break;
        }
        return QueueList;
    }

}
