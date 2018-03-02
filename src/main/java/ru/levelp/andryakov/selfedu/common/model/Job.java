package ru.levelp.andryakov.selfedu.common.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", updatable = false, insertable = false)
    private int jobId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date startDate;

    @Column
    private Date finishDate;

    @Column
    private int gain;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Goal goal;

    public Job() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public int getGain() {
        return gain;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}



