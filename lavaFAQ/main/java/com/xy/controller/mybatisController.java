package com.xy.controller;

import com.xy.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by helloworld on 2014/11/22.
 */
@Controller
public class mybatisController {

    @Autowired
    NameService nameService;

    @RequestMapping(value = "/addName", method = RequestMethod.POST)
    ModelMap addName(@RequestParam("hasException") boolean hasException) {
        try {
            nameService.addQaAndDev(hasException);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelMap("false");
        }
        return new ModelMap("true");
    }


}
