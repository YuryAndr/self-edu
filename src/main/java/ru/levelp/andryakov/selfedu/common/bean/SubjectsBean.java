package ru.levelp.andryakov.selfedu.common.bean;

import ru.levelp.andryakov.selfedu.dao.SubjectsDAO;
import ru.levelp.andryakov.selfedu.common.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SubjectsBean {
    private final EntityManagerFactory factory;
    private final EntityManager em;
    private final SubjectsDAO subjectsDAO;

    public SubjectsBean() {
        //TODO: make singleton to get manager
        //TODO: servetllistener instead of Servlet.destroy()
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        subjectsDAO = new SubjectsDAO(em);
        subjectsDAO.addSubject("123");
    }

    public List<Subject> getSubjects() {
        return subjectsDAO.listSubjects();
    }
}
