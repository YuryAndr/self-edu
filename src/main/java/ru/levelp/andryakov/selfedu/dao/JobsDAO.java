package ru.levelp.andryakov.selfedu.dao;

import ru.levelp.andryakov.selfedu.model.Goal;
import ru.levelp.andryakov.selfedu.model.Job;
import ru.levelp.andryakov.selfedu.model.Subject;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//TODO: mark find as nullable

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

        try {
            HibernateHelper.persistInstance(job, em);
        } catch (Throwable t) {
            System.out.println("Error while adding job\n\t" + t.getStackTrace());
        }
        return job;
    }

    public void finishJob(Job job) {
        job.setFinishDate(new Date());
        try {
            HibernateHelper.persistInstance(job, em);
        } catch (Throwable t) {
            System.out.println("Error while adding job\n\t" + t.getStackTrace());
        }
    }

    public List<Subject> listJobs (Goal goal) {
        try {
            return (List<Subject>) em.createQuery("select j from Jobs j where j.goal = :goal")
                    .setParameter("goal", goal)
                    .getResultList();
        } catch (NoResultException notFound) {
            return null;
        }
    }

}
