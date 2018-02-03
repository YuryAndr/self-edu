package ru.levelp.andryakov.selfedu.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.levelp.andryakov.selfedu.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class UsersDAOTest {

    EntityManagerFactory factory;
    EntityManager em;
    UsersDAO usersDAO;


    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        usersDAO = new UsersDAO(em);
    }

    @After
    public void closeResources() {
        em.close();
        factory.close();
    }

    @Test
    public void whenUserAddedThenListUsersReturnsUser() throws Exception {
        usersDAO.addUser("test","test");
        List<User> users = usersDAO.listUsers();
        String login = users.get(0).getLogin();
        assertEquals(login, "test");
    }
}