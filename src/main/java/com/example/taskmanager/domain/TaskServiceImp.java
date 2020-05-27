package com.example.taskmanager.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    SubTaskRepo subTaskRepo;

    @Autowired
    public TaskServiceImp(){

    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(TaskDTO task) {
        taskRepository.save(new Task(task.getTitle(),task.getDescription(),task.getDateTime(),task.getId()));
    }

    @Override
    public TaskDTO getTask(UUID id) {
         if (taskRepository.findById(id).isPresent()){
             Task task = taskRepository.findById(id).get();
             TaskDTO taskDTO = TaskDTO.toTaskDTO(task);
             return taskDTO;
         } else {
             throw new IllegalArgumentException();
         }
    }


    @Override
    public void edit(TaskDTO task) {
        TaskDTO etask = getTask(task.getId());
        etask.setDescription(task.getTitle());
        etask.setDateTime(task.getDateTime());
        etask.setTitle(task.getTitle());
        addTask(etask);
    }

    @Override
    public void addSubTask(String id, SubTaskDTO subTaskDTO) {
        Task task =   taskRepository.findById(UUID.fromString(id)).get();
        SubTask subTask = SubTaskDTO.toSubTask(subTaskDTO);
        subTaskRepo.save(subTask);
        task.addSubTask(subTask);
        taskRepository.save(task);
    }
}
