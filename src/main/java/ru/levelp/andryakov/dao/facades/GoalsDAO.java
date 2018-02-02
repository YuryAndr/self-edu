package ru.levelp.andryakov.dao.facades;

import ru.levelp.andryakov.dao.entities.Goal;
import ru.levelp.andryakov.dao.entities.Job;
import ru.levelp.andryakov.dao.entities.Subject;
import ru.levelp.andryakov.dao.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class GoalsDAO {

    private final EntityManager em;

    public GoalsDAO(EntityManager em) {
        this.em = em;
    }

    public void addGoal(String title, int finalProgress, User user) {
        addGoal(title, finalProgress, user, null);

    }

    public void addGoal(String title, int finalProgress, User user, Subject subject) {
        Goal goal = new Goal();
        goal.setUser(user);
        goal.setTitle(title);
        goal.setSubject(subject);

        try {
            HibernateHelper.persistInstance(goal, em);
        } catch (Throwable t) {
            System.out.println("Error while adding goal\n\t" + t.getStackTrace());
        }
    }

    public List<Goal> listGoals(User user) {
        try {
            return (List<Goal>) em.createQuery("select g from Goal g where g.user = :user")
                    .setParameter("user", user)
                    .getResultList();
        } catch (NoResultException notFound) {
            return null;
        }
    }

    public List<Goal> listGoals(User user, Subject subject) {
        try {
            return (List<Goal>) em.createQuery("select g from Goal where g.user = :user AND g.subject = :subject")
                    .setParameter("user", user)
                    .setParameter("subject", subject)
                    .getResultList();
        } catch (NoResultException notFound) {
            return null;
        }
    }
}