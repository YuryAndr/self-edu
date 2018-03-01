package ru.levelp.andryakov.selfedu.common.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", updatable = false, insertable = false)
    private int subjectId;

    @Column
    private String title;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Goal> goals;

    public Subject() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }
}
