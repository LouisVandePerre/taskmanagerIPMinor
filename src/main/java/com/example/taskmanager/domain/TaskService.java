package com.example.taskmanager.domain;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.SubTaskDTO;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface TaskService {

     List<Task> getTasks();
     void addTask(TaskDTO task);
     TaskDTO getTask(UUID id);

     void edit(TaskDTO task);

     void addSubTask(String id, SubTaskDTO task);
}
