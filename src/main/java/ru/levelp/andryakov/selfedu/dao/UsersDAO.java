package ru.levelp.andryakov.selfedu.dao;

import org.springframework.stereotype.Repository;
import ru.levelp.andryakov.selfedu.common.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UsersDAO {

    private final EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public User addUser (String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        try {
            HibernateHelper.persistInstance(user, em);
        } catch (Throwable t) {
            System.out.println("Error while adding user\n\t" + t.getStackTrace());
        }
        return user;
    }

    public List<User> listUsers() {
        return HibernateHelper.selectFullIstancesList("select u from User u",em);
    }

    public User getUser(String login) {
        try {
            return (User) em.createQuery("select u from User u where u.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException notFound) {
            return null;
        }
    }
}
