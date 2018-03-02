package ru.levelp.andryakov.selfedu.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.levelp.andryakov.selfedu.dao.UsersDAO;

import java.util.Date;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String getStartingPage(ModelMap model) {
        model.put("time", new Date().toString());
        return "startingPage";
    }

}
