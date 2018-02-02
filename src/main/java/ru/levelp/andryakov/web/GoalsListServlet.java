package ru.levelp.andryakov.web;

import ru.levelp.andryakov.dao.entities.Goal;
import ru.levelp.andryakov.dao.entities.User;
import ru.levelp.andryakov.dao.facades.GoalsDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoalsListServlet extends HttpServlet {

    private int count;
    private User user;
    private GoalsDAO goalsDAO;
    private EntityManagerFactory factory;
    private EntityManager em;

    @Override
    public void init() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        goalsDAO = new GoalsDAO(em);
        user = new User();
        user.setLogin("test");
        user.setPassword("test");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        goalsDAO.addGoal("Stop visit this page " + count++, 100, user);
        List<Goal> goals = goalsDAO.listGoals(user);
        response.getWriter().append( "<html>\n" +
                                        "<body>\n");
        for (Goal goal:goals) {
            response.getWriter().append("<h2>" + goal.getTitle() + "</h2>\n");
        }

        response.getWriter().append("</body>\n" +
                                    "</html>");
    }

    @Override
    public void destroy() {
        em.close();
        factory.close();
    }
}
