package ru.levelp.andryakov.selfedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelp.andryakov.selfedu.common.bean.GoalBean;
import ru.levelp.andryakov.selfedu.common.model.Goal;
import ru.levelp.andryakov.selfedu.common.model.Job;
import ru.levelp.andryakov.selfedu.common.model.User;
import ru.levelp.andryakov.selfedu.dao.GoalsDAO;
import ru.levelp.andryakov.selfedu.dao.JobsDAO;
import ru.levelp.andryakov.selfedu.dao.UsersDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalsService {
    private final GoalsDAO goalsDAO;
    private final UsersDAO usersDAO;
    private final JobsDAO jobsDAO;

    @Autowired
    public GoalsService(GoalsDAO goalsDAO, UsersDAO usersDAO, JobsDAO jobsDAO) {
        this.goalsDAO = goalsDAO;
        this.usersDAO = usersDAO;
        this.jobsDAO = jobsDAO;
    }


    public void addGoal(GoalBean goalBean, String login) {
        User user = usersDAO.getUser(login);
        Goal goal = new Goal();
        goal.setUser(user);
        goal.setTitle(goalBean.getTitle());
        goal.setFinalProgress(goalBean.getFinalProgress());
        goalsDAO.addGoal(goal);
    }

    public List<GoalBean> listGoals(String login) {
        User user = usersDAO.getUser(login);
        List<Goal> goals = goalsDAO.listGoals(user);
        List<GoalBean> goalBeans = new ArrayList<>();
        if (goals != null) {
            goals.forEach((Goal goal) -> {
                GoalBean goalBean = new GoalBean();
                goalBean.setTitle(goal.getTitle());
                goalBean.setFinalProgress(goal.getFinalProgress());
                goalBean.setId(goal.getGoalId());
                List<Job> jobs = jobsDAO.listJobs(goal);
                if (jobs != null) {
                    goalBean.setCurrentProgress(
                            jobs.stream()
                                    .mapToInt(Job::getGain)
                                    .sum()
                    );
                }
                goalBeans.add(goalBean);
            });
        }
        return goalBeans;
    }
}
