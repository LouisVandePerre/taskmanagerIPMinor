package com.example.taskmanager;

import com.example.taskmanager.domain.DbInArrayList;
import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class DbArrayTest {

    @Test
    void TestAddingAndEditingromDbArray() {
        LocalDateTime date = LocalDateTime.of(3030, 1, 1, 1, 1);
        Task testtask = new Task("testtask", "testaskteron",date);
        SubTask st = new SubTask("kqsdjkf","qksjdkml");
        ArrayList<SubTask> arrayList= new ArrayList<>();
        DbInArrayList dbInArrayList = new DbInArrayList();
        dbInArrayList.addTask(testtask);
        assertEquals(dbInArrayList.getTask(testtask.getId()),testtask);
        testtask.setTitle("qszkdejfjlhsdqeiojuf");
        dbInArrayList.edit(testtask);
        assertEquals(dbInArrayList.getTask(testtask.getId()),testtask);
        //no erros in assing subtast


    }

    @Test
    void TestAddingSubtasks() {
        LocalDateTime date = LocalDateTime.of(3030, 1, 1, 1, 1);
        Task testtask = new Task("testtask", "testaskteron",date);
        DbInArrayList dbInArrayList = new DbInArrayList();
        dbInArrayList.addTask(testtask);
        SubTask subTask = new SubTask("oqsjsdhdkfhqsk","olqsjdhjdf");
        dbInArrayList.addSubTask(String.valueOf(testtask.getId()),subTask);
        ArrayList<SubTask> subTasks = new ArrayList<>();
        subTasks.add(subTask);
        assertEquals(subTasks, testtask.getSubtasks());
    }
}
