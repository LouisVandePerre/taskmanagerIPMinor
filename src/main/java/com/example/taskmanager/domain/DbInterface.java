package com.example.taskmanager.domain;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface DbInterface {
    
    void addTask(Task task);
    Task getTask(UUID id);

    List<Task> getAllTasks();
    int getTaskId(Task task);

    Task getTaskAndDelete(UUID id);

    void edit(Task task);

    void addSubTask(String id, SubTask task);
}
