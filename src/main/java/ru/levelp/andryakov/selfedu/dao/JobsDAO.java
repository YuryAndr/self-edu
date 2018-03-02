package ru.levelp.andryakov.selfedu.dao;

import org.springframework.stereotype.Repository;
import ru.levelp.andryakov.selfedu.common.model.Goal;
import ru.levelp.andryakov.selfedu.common.model.Job;
import ru.levelp.andryakov.selfedu.common.model.Subject;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//TODO: mark find as nullable

@Repository
public class JobsDAO {

    private final EntityManager em;

    public JobsDAO(EntityManager em) {
        this.em = em;
    }

    public Job addJob(String title, String description, int gain) {
        Job job = new Job();
        job.setTitle(title);
        job.setGain(gain);
        job.setStartDate(new Date());
        job.setDescription(description);
        return addJob(job);
    }

    public void finishJob(Job job) {
        job.setFinishDate(new Date());
        try {
            HibernateHelper.persistInstance(job, em);
        } catch (Throwable t) {
            System.out.println("Error while adding job\n\t" + t.getStackTrace());
        }
    }

    public List<Job> listJobs (Goal goal) {
        try {
            return (List<Job>) em.createQuery("select j from Job j where j.goal = :goal")
                    .setParameter("goal", goal)
                    .getResultList();
        } catch (NoResultException notFound) {
            return null;
        }
    }

    public Job addJob(Job job) {
        try {
            HibernateHelper.persistInstance(job, em);
        } catch (Throwable t) {
            System.out.println("Error while adding job\n\t" + t.getStackTrace());
        }
        return job;
    }
}
