package com.example.taskmanager.domain;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Task {
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private String description;
    @OneToMany
    private List<SubTask> subtasks;
    @Id
    private UUID id;

    public Task(String title, String desc, LocalDateTime dateTime,UUID id){
        setDateTime(dateTime);
        setTitle(title);
        setDescription(desc);
        setId(id);
        subtasks = new ArrayList<>();
    }

    public Task(String title, String desc, LocalDateTime dateTime){
        setDateTime(dateTime);
        setTitle(title);
        setDescription(desc);
        setId(UUID.randomUUID());
        subtasks = new ArrayList<>();
    }

    public Task(){
        setId(UUID.randomUUID());
        subtasks = new ArrayList<>();
    }


    public void setTitle(String title) {
        if(title.isEmpty()){
            throw new IllegalArgumentException("title is empty");
        }
        this.title = title;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if(dateTime.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("date has already passed");
        }
        this.dateTime = dateTime;
    }

    public String getTitle() {

        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDescription(String description) {
        if(description.isEmpty()){
            throw new IllegalArgumentException("description is empty");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<SubTask> getSubtasks() {
        return subtasks;
    }

    public void addSubTask(SubTask task) {
        if(task == null){
            throw new IllegalArgumentException("subtask is empty");
        }
        subtasks.add(task);
    }

}
