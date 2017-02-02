package com.frank.controller;

import com.frank.dto.JsonResult;
import com.frank.entity.Student;
import com.frank.service.QueueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by frank on 17/2/2.
 */
@Controller
@RequestMapping("/screen")
public class ScreenController {

    @Resource
    private QueueService queueService;

    @RequestMapping(value = "/sign", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> sign(@RequestBody Student student){
        if (student.getFirstWish().equals(student.getSecondWish())){
            queueService.queueIn(student.getFirstWish(),student);
        }else {
            queueService.queueIn(student.getFirstWish(),student);
            queueService.queueIn(student.getSecondWish(),student);
        }
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/stick/{ul}/{li}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> stick(@PathVariable int ul,@PathVariable int li){
        queueService.stick(ul,li);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/remove/{ul}/{li}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> remove(@PathVariable int ul,@PathVariable int li){
        queueService.remove(ul,li);
        return new JsonResult<>(true);
    }


}
