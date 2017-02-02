package com.frank.service;

import com.frank.entity.Student;

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
}
