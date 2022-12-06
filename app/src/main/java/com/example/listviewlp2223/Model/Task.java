package com.example.listviewlp2223.Model;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean isFinished;

    public Task(int id, String title, String description, boolean isFinished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isFinished = isFinished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                '}';
    }
}
