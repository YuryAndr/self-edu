package ru.levelp.andryakov.dao.facades;

import ru.levelp.andryakov.dao.entities.Subject;
import ru.levelp.andryakov.dao.entities.User;

import javax.persistence.*;
import java.util.List;

public class UsersDAO {

    private final EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public void addUser (String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        try {
            HibernateHelper.persistInstance(user, em);
        } catch (Throwable t) {
            System.out.println("Error while adding user\n\t" + t.getStackTrace());
        }
    }

    public List<User> listUsers() {
        return HibernateHelper.selectFullIstancesList("select u from User u",em);
    }
}