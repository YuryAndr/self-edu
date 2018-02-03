package ru.levelp.andryakov.selfedu.web;

import ru.levelp.andryakov.selfedu.model.Goal;
import ru.levelp.andryakov.selfedu.model.User;
import ru.levelp.andryakov.selfedu.dao.GoalsDAO;
import ru.levelp.andryakov.selfedu.dao.UsersDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoalsListServlet extends HttpServlet {

    private User user;
    private GoalsDAO goalsDAO;
    private EntityManagerFactory factory;
    private EntityManager em;

    @Override
    public void init() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        goalsDAO = new GoalsDAO(em);
        UsersDAO usersDAO = new UsersDAO(em);
        usersDAO.addUser("test","test");
        user = usersDAO.listUsers().get(0);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Goal> goals = goalsDAO.listGoals(user);
        int numberOfGoals = goals.size();
        Goal goal = goalsDAO.addGoal("Stop visit this page " + numberOfGoals, 100, user);
        goals.add(goal);
//        StringBuilder sb = new StringBuilder();
//        sb.append( "<html>\n" +
//                                        "<body>\n");
//        for (Goal goal:goals) {
//            sb.append("<h2>" + goal.getTitle() + "</h2>\n");
//        }
//
//        sb.append("</body>\n" +
//                                    "</html>");
//        response.getWriter().append(sb);
        request.setAttribute("goals", goals);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/list_of_goals.jsp");
        rd.forward(request, response);
    }

    @Override
    public void destroy() {
        em.close();
        factory.close();
    }
}
