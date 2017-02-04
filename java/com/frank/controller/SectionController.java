package com.frank.controller;

import com.frank.dto.JsonResult;
import com.frank.entity.Record;
import com.frank.entity.Student;
import com.frank.service.InterviewService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by frank on 17/2/2.
 */
@Controller
@RequestMapping("/section")
public class SectionController {

    @Resource
    private InterviewService interviewService;

    @RequestMapping(value = "/{section_id}/getInterviewee", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getInterviewee(@PathVariable int section_id){
        if (section_id == 0){
            return new JsonResult<>(false);
        }

        Student student = interviewService.getInterviewee(section_id);
        if (student != null){
            return new JsonResult<>(true,student);
        }else {
            return new JsonResult<>(false);//表示没有人了
        }
    }

    @RequestMapping(value = "/{section_id}/getWaitNum", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getWaitNum(@PathVariable int section_id){
        if (section_id == 0){
            return new JsonResult<>(false);
        }
        return new JsonResult<>(true,interviewService.getWaitNum(section_id));
    }

    @RequestMapping(value = "/{section_id}/beginInterview", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> beginInterview(@PathVariable int section_id){
        interviewService.beginInterview(section_id);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/{section_id}/skipInterview", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> skipInterview(@PathVariable int section_id){
        interviewService.skipInterview(section_id);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/{section_id}/doneInterview", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> doneInterview(@PathVariable int section_id,@RequestBody Record record){
        interviewService.doneInterview(record);
        return new JsonResult<>(true);
    }

    @RequestMapping(value = "/{section_id}/getRecords", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getRecords(@PathVariable int section_id){
        return new JsonResult<>(true,interviewService.getSectionRecords(section_id));
    }

    @RequestMapping(value = "/{section_id}/exportRecords", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void exportRecords(@PathVariable int section_id,HttpServletResponse response){
        HSSFWorkbook wb = interviewService.createExcel(section_id);
        try {
            response.setHeader("Content-Disposition", "attachment; filename=records.xls");
            response.setContentType("application/vnd.ms-excel; charset=utf-8") ;
            OutputStream out = response.getOutputStream() ;
            wb.write(out) ;
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
