package com.example.taskmanager.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class TaskDTO {

    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private String description;
    private List<SubTask> subtasks;
    private UUID id;

    public TaskDTO(String title, LocalDateTime dateTime, String description, List<SubTask> subtasks, UUID id) {
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.subtasks = subtasks;
        this.id = id;
    }

    public TaskDTO() {
        id = UUID.randomUUID();
    }

    public static Task toTask(TaskDTO bigTask) {
        return new Task(bigTask.getTitle(),bigTask.getDescription(),bigTask.getDateTime(),bigTask.getId());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubTask> getSubtasks() {
        return subtasks;
    }


    public String getDeuDate(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' HH:mm");
        return dateTimeFormatter.format(dateTime);
    }

    public void setSubtasks(List<SubTask> subtasks) {
        this.subtasks = subtasks;
    }

    public static TaskDTO toTaskDTO(Task task){
        return new TaskDTO(task.getTitle(),task.getDateTime(),task.getTitle(),task.getSubtasks(),task.getId());
    }
}
