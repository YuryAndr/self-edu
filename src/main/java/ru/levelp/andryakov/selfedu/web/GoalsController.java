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
        Goal goal = new Goal();
        goal.setTitle(goalBean.getTitle());
        goal.setFinalProgress(goalBean.getFinalProgress());
        goalsService.addGoal(goal);
        return "goal/create";
    }
}
