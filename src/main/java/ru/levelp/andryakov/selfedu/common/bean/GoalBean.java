package ru.levelp.andryakov.selfedu.common.bean;

public class GoalBean {
    private String title;
    private int finalProgress;
    private int currentProgress;

    public int getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(int currentProgress) {
        this.currentProgress = currentProgress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFinalProgress() {
        return finalProgress;
    }

    public void setFinalProgress(int finalProgress) {
        this.finalProgress = finalProgress;
    }
}
