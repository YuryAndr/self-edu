package ru.levelp.andryakov.selfedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelp.andryakov.selfedu.common.bean.GoalBean;
import ru.levelp.andryakov.selfedu.common.bean.JobBean;
import ru.levelp.andryakov.selfedu.common.model.Goal;
import ru.levelp.andryakov.selfedu.common.model.Job;
import ru.levelp.andryakov.selfedu.common.model.Subject;
import ru.levelp.andryakov.selfedu.common.model.User;
import ru.levelp.andryakov.selfedu.dao.GoalsDAO;
import ru.levelp.andryakov.selfedu.dao.JobsDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsService {
    private final GoalsDAO goalsDAO;
    private final JobsDAO jobsDAO;

    @Autowired
    public JobsService(GoalsDAO goalsDAO, JobsDAO jobsDAO) {
        this.goalsDAO = goalsDAO;
        this.jobsDAO = jobsDAO;
    }

    public void addJob(JobBean jobBean, int id) {
        Goal goal =goalsDAO.getGoal(id);
        Job job = new Job();
        job.setGoal(goal);
        job.setTitle(jobBean.getTitle());
        job.setGain(jobBean.getGain());
        jobsDAO.addJob(job);
    }

    public List<JobBean> listJobs(int id) {
        Goal goal = goalsDAO.getGoal(id);
        List<JobBean> jobBeans = new ArrayList<>();
        if (goal != null) {
            List<Job> jobs = jobsDAO.listJobs(goal);
            if (jobs != null) {
                jobs.forEach((Job job) -> {
                    JobBean jobBean = new JobBean();
                    jobBean.setTitle(job.getTitle());
                    jobBean.setGain(job.getGain());
                    jobBeans.add(jobBean);
                });
            }
        }
        return jobBeans;
    }
}
