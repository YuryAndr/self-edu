package ru.levelp.andryakov.selfedu.dao;

import ru.levelp.andryakov.selfedu.model.Subject;

import javax.persistence.*;
import java.util.List;

public class SubjectsDAO {

    private final EntityManager em;

    public SubjectsDAO(EntityManager em) {
        this.em = em;
    }

    public Subject addSubject (String title) {
        Subject subject = new Subject();
        subject.setTitle(title);

        try {
            HibernateHelper.persistInstance(subject, em);
        } catch (Throwable t) {
            System.out.println("Error while adding subject\n\t" + t.getStackTrace());
        }
        return subject;
    }

    public List<Subject> listSubjects () {
        return HibernateHelper.selectFullIstancesList("select s from Subject s",em);
    }
}
