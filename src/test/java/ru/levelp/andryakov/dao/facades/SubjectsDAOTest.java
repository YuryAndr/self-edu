package ru.levelp.andryakov.dao.facades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelp.andryakov.dao.entities.Subject;
import ru.levelp.andryakov.dao.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class SubjectsDAOTest {

    EntityManagerFactory factory;
    EntityManager em;
    SubjectsDAO subjectsDAO;


    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        subjectsDAO = new SubjectsDAO(em);
    }

    @After
    public void closeResources() {
        em.close();
        factory.close();
    }


    @Test
    public void whenSubjectAddedThenListSubjectsReturnsSubject() throws Exception {
        subjectsDAO.addSubject("test");
        List<Subject> subjects = subjectsDAO.listSubjects();
        String title = subjects.get(0).getTitle();
        assertEquals(title, "test");
    }
}