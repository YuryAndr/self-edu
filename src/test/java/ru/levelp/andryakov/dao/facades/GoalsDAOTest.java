package ru.levelp.andryakov.dao.facades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelp.andryakov.dao.entities.Goal;
import ru.levelp.andryakov.dao.entities.Subject;
import ru.levelp.andryakov.dao.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

public class GoalsDAOTest {

    EntityManagerFactory factory;
    EntityManager em;
    GoalsDAO goalsDAO;


    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        goalsDAO = new GoalsDAO(em);
    }

    @After
    public void closeResources() {
        em.close();
        factory.close();
    }

    @Test
    public void whenGoalAddedByUserThenListGoalsReturnsGoalByUser() throws Exception {
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        goalsDAO.addGoal("test goal",100, user);
        List<Goal> goals = goalsDAO.listGoals(user);
        String title = goals.get(0).getTitle();
        assertEquals(title, "test goal");
    }

    @Test
    public void whenGoalAddedByUserAndSubjectThenListGoalsReturnsGoalByUserAndSubject() throws Exception {
        Subject subject = new Subject();
        subject.setTitle("Test subject");
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        goalsDAO.addGoal("test goal",100, user, subject);
        List<Goal> goals = goalsDAO.listGoals(user);
        String title = goals.get(0).getTitle();
        assertEquals(title, "test goal");
    }

}