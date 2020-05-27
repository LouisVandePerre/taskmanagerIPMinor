package com.example.taskmanager.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

    public SubTask(){};

    public SubTask(String title, String desc){
        setDescription(desc);
        setTitle(title);
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

}
