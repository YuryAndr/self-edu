package ru.levelp.andryakov.selfedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelp.andryakov.selfedu.common.model.Goal;
import ru.levelp.andryakov.selfedu.dao.GoalsDAO;

@Service
public class GoalsService {
    private final GoalsDAO goalsDAO;

    @Autowired
    public GoalsService(GoalsDAO goalsDAO) {
        this.goalsDAO = goalsDAO;
    }


    public void addGoal(Goal goal) {
        goalsDAO.addGoal(goal);
    }
}
