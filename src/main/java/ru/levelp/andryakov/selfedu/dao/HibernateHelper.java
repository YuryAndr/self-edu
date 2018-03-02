package ru.levelp.andryakov.selfedu.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;

public class HibernateHelper {

    public static <E> void persistInstance (E e, EntityManager em) throws Throwable {
        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw new PersistenceException().initCause(t);
        }
    }

    public static <E> List<E> selectFullIstancesList (String query, EntityManager em) {
        try {
            return (List<E>) em.createQuery(query)
                    .getResultList();
        } catch (NoResultException notFound) {
            return null;
        }
    }

}
