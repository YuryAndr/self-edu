package ru.levelp.andryakov.selfedu.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String getStartingPage(ModelMap model) {
        model.put("time", new Date().toString());

        return "startingPage";
    }

}
