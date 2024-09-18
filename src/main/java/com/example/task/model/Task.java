package com.example.task.model;

import java.util.Date;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Date createDate;
    private Date completedDate;

    public Task(Long id, String title, String description, Boolean completed, Date createDate, Date completedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createDate = createDate;
        this.completedDate = completedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
}
