package ru.levelp.andryakov.selfedu.common.model;

import javax.persistence.*;
import java.util.List;
//TODO : mark nullable
//
@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id", updatable = false, insertable = false)
    private int goalId;

    @Column
    private String title;

    @Column
    private int finalProgress;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Subject subject;

    @OneToMany(mappedBy = "goal", fetch = FetchType.LAZY)
    private List<Job> jobs;

    public Goal() {
    }

    public int getFinalProgress() {
        return finalProgress;
    }

    public void setFinalProgress(int finalProgress) {
        this.finalProgress = finalProgress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
