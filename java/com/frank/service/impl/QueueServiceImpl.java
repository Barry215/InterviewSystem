package com.frank.service.impl;

import com.frank.entity.Queue;
import com.frank.entity.Student;
import com.frank.service.InterviewService;
import com.frank.service.QueueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by frank on 17/2/2.
 */
@Service
public class QueueServiceImpl implements QueueService {

    @Resource
    private InterviewService interviewService;

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
                if (Queue.queue_1.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_1.get(0).getsId());
                    Queue.queue_1.remove(0);
                }else {
                    interviewService.freeSection(QueueName);
                }
                break;
            case 2:
                if (Queue.queue_2.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_2.get(0).getsId());
                    Queue.queue_2.remove(0);
                }else {
                    interviewService.freeSection(QueueName);
                }
                break;
            case 3:
                if (Queue.queue_3.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_3.get(0).getsId());
                    Queue.queue_3.remove(0);
                }else {
                    interviewService.freeSection(QueueName);
                }
                break;
            case 4:
                if (Queue.queue_4.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_4.get(0).getsId());
                    Queue.queue_4.remove(0);
                }else {
                    interviewService.freeSection(QueueName);
                }
                break;
            case 5:
                if (Queue.queue_5.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_5.get(0).getsId());
                    Queue.queue_5.remove(0);
                }else {
                    interviewService.freeSection(QueueName);
                }
                break;
            case 6:
                if (Queue.queue_6.size() > 0){
                    interviewService.updateInterviewee(QueueName,Queue.queue_6.get(0).getsId());
                    Queue.queue_6.remove(0);
                }else {
                    interviewService.freeSection(QueueName);
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
}
