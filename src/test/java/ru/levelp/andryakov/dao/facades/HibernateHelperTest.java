package ru.levelp.andryakov.dao.facades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelp.andryakov.dao.entities.User;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HibernateHelperTest {

    EntityManagerFactory factory;
    EntityManager em;


    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
    }

    @After
    public void closeResources() {
        em.close();
        factory.close();
    }

    @Test
    public void whenInstancesAddedThenSelectFullListIstancesReturnsInstances() throws Throwable {
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        HibernateHelper.persistInstance(user,em);
        List<User> users = HibernateHelper.selectFullIstancesList("select u from User u", em);
        String login = users.get(0).getLogin();
        assertEquals(login, "test");
    }
}