package com.example.taskmanager.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class DbInArrayList implements DbInterface {


    private ArrayList<Task> tasks;

    public DbInArrayList(){
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Task getTask(UUID id) {
        for(Task t:tasks){
            if(t.getId().equals( id)){
                return t;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public int getTaskId(Task task) {
        return tasks.indexOf(task);
    }

    @Override
    public Task getTaskAndDelete(UUID id) {
        Task task = getTask(id);
        tasks.remove(id);
        return task;
    }

    @Override
    public void edit(Task task) {
        for(Task t:tasks){
            if(t.getId().equals(task.getId())){
                tasks.set(tasks.indexOf(t), task);
            }
        }
    }

    @Override
    public void addSubTask(String id, SubTask task) {
        Task firstTask = getTask(UUID.fromString(id));
        firstTask.addSubTask(task);
    }
}
