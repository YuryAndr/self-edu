package ru.levelp.andryakov.selfedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.levelp.andryakov.selfedu.common.bean.GoalBean;
import ru.levelp.andryakov.selfedu.common.model.Goal;
import ru.levelp.andryakov.selfedu.service.GoalsService;

import java.util.List;

@RequestMapping(value = "/goal")
@Controller
public class GoalsController {

    private final GoalsService goalsService;

    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }

    @GetMapping(value = "/create")
    public String getCreateGoal(Model model) {
        model.addAttribute("goalBean", new GoalBean());
        return "goal/create";
    }

    @PostMapping(value = "/create")
    public String postCreateGoal(@ModelAttribute GoalBean goalBean) {
        //TODO: убрать костыль после изучения регистрации и аутентификации
        goalsService.addGoal(goalBean, "admin");
        return "redirect:/goal/list";
    }

    @GetMapping(value = "/list")
    public String getListGoals(Model model) {
        //TODO: убрать костыль после изучения регистрации и аутентификации
        List<GoalBean> goalBeans = goalsService.listGoals("admin");
        model.addAttribute("goalBeans", goalBeans);
        return "goal/list";
    }
}
