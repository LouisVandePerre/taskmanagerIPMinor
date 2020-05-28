package com.example.taskmanager.controller;

import com.example.taskmanager.domain.SubTaskDTO;
import com.example.taskmanager.domain.TaskDTO;
import com.example.taskmanager.domain.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@Controller
public class tasksController {

    final
    TaskService taskService;
    public tasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks",taskService.getTasks());
        return "index";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") String id){
        TaskDTO task = taskService.getTask(UUID.fromString(id));
        model.addAttribute("task",task);
        model.addAttribute("subtasks",task.getSubtasks());
        return "taskDetails";
    }

    @GetMapping("/tasks/new")
    public String goToAddTask(Model model){
        model.addAttribute("taskDTO",new TaskDTO());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return "addTask";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/edit/{id}")
    public String goToEdit(Model model, @PathVariable("id") String id){
        TaskDTO task = taskService.getTask(UUID.fromString(id));
        model.addAttribute("task",task);
        return "editTask";
    }

    @PostMapping("/editTask")
    public String editTask(@ModelAttribute TaskDTO task){
        taskService.edit(task);
        return "redirect:/tasks";
    }


    @GetMapping("/tasks/{id}/sub/create")
    public String goToAddSubTask(Model model, @PathVariable("id") String id){
        TaskDTO task = taskService.getTask(UUID.fromString(id));
        model.addAttribute("task",task);
        return "addSubtask";
    }

    @PostMapping("/addSubTask")
    public String addSubTask( @RequestParam(value = "id") String id,@ModelAttribute SubTaskDTO subTask){
        taskService.addSubTask(id,subTask);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
