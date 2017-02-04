package com.frank.service;

import com.frank.dto.QueueInfo;
import com.frank.dto.SectionState;
import com.frank.entity.Section;
import com.frank.entity.Student;

import java.util.List;

/**
 * Created by frank on 17/2/2.
 */
public interface QueueService {
    void queueIn(int QueueName,Student student);

    void queueOut(int QueueName);

    void remove(int QueueName,int index);

    void stick(int QueueName, int index);

    void clearAllQueue();

    boolean isEmpty(int QueueName);

    boolean addStudent(Student student);

    List<SectionState> getSectionState();

    List<QueueInfo> getQueueInfoList();

}
