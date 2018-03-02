package ru.levelp.andryakov.selfedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.levelp.andryakov.selfedu.common.bean.GoalBean;
import ru.levelp.andryakov.selfedu.common.bean.JobBean;
import ru.levelp.andryakov.selfedu.service.GoalsService;
import ru.levelp.andryakov.selfedu.service.JobsService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/job")
@Controller
public class JobsController {

    private final JobsService jobsService;

    @Autowired
    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping(value = "/create")
    public String getCreateGoal(@RequestParam int goalId, Model model) {
        model.addAttribute("jobBean", new JobBean());
        return "job/create";
    }

    @PostMapping(value = "/create")
    public String postCreateGoal(@RequestBody MultiValueMap<String,String> formData, @ModelAttribute JobBean jobBean, RedirectAttributes redirectAttributes) {
        jobsService.addJob(jobBean, Integer.parseInt(formData.getFirst("goalId")));
        redirectAttributes.addAttribute("goalId",formData.getFirst("goalId"));
        return "redirect:/job/list";
    }

    @GetMapping(value = "/list")
    public String getListGoals(@RequestParam int goalId, Model model) {
        List<JobBean> jobBeans = jobsService.listJobs(goalId);
        model.addAttribute("jobBeans", jobBeans);
        return "job/list";
    }
}
