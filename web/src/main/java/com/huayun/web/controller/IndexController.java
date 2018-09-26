package com.huayun.web.controller;

import com.huayun.model.entity.Test;
import com.huayun.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    TestService testService;
    @RequestMapping(value="/toIndex/{name}")
    public String index(@PathVariable("name") String  name,Model model){
        log.info("进入首页--------");
        List<Test> testList=testService.getAllUser();
        if(!StringUtils.isEmpty(testList)){
            log.info("testList={},name=",testList,testList.get(0).getName());
            name=testList.get(0).getName();
        }
        model.addAttribute("name",name);
        return "hello";
    }
    @RequestMapping(value="/list/{name}")
    public String getList(Model model){
        return "userList";
    }
}
