package com.frank.controller;

import com.frank.dao.SectionMapper;
import com.frank.dto.JsonResult;
import com.frank.dto.QueueInfo;
import com.frank.dto.SectionState;
import com.frank.entity.Queue;
import com.frank.entity.Section;
import com.frank.entity.Student;
import com.frank.service.QueueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 17/2/2.
 */
@Controller
@RequestMapping("/screen")
public class ScreenController {

    @Resource
    private QueueService queueService;

    @RequestMapping(value = "/initQueue", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> initQueue(){
        return new JsonResult<>(true,queueService.getQueueInfoList());
    }

    @RequestMapping(value = "/sign", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> sign(@RequestBody Student student){
        if (student.getFirstWish().equals(student.getSecondWish())){
            queueService.queueIn(student.getFirstWish(),student);
        }else {
            queueService.queueIn(student.getFirstWish(),student);
            queueService.queueIn(student.getSecondWish(),student);
        }
        queueService.addStudent(student);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/stick/{ul}/{li}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> stick(@PathVariable int ul,@PathVariable int li){
        queueService.stick(ul,li);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/remove/{ul}/{li}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> remove(@PathVariable int ul,@PathVariable int li){
        queueService.remove(ul,li);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/clearAllQueue", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> clearAllQueue(){
        queueService.clearAllQueue();
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/getSectionState", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getSectionState(){
        List<SectionState> sectionStates = queueService.getSectionState();
        return new JsonResult<>(true,sectionStates);
    }
}
