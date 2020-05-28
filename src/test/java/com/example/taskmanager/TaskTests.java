package com.example.taskmanager;
import static org.junit.jupiter.api.Assertions.*;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;

@SpringBootTest
class TaskTests {

    @Test
    void testGetters(){
        LocalDateTime date = LocalDateTime.of(3030,1,1,1,1);
        Task t = new Task("testtask","testaskteron", date);
        assertEquals("testtask", t.getTitle());
        assertEquals("testaskteron", t.getDescription());
        assertEquals(date, t.getDateTime());
        TaskDTO taskDTO = TaskDTO.toTaskDTO(t);
        assertEquals(taskDTO.getTitle(),t.getTitle());
        assertEquals(taskDTO.getDescription(),t.getDescription());

        assertEquals(taskDTO.getDeuDate(),"January 01 3030 at 01:01");
        assertEquals(taskDTO.getDescription(),t.getDescription());
    }
    @Test
    void testSetters(){
        LocalDateTime date = LocalDateTime.of(3030,1,1,1,1);
        LocalDateTime date2 = LocalDateTime.of(3000,1,1,1,1);
        Task t = new Task("testtask","testaskteron", date);
        t.setTitle("tasktest");
        t.setDescription("testosteron");
        t.setDateTime(date2);
        assertEquals("tasktest", t.getTitle());
        assertEquals("testosteron", t.getDescription());
        assertEquals(date2, t.getDateTime());
    }

    @Test
    void Illegalargumetns(){

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("","testaskteron", LocalDateTime.of(3030,1,1,1,1));
        });

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("qsdqsd","", LocalDateTime.of(3030,1,1,1,1));
        });

        exception = assertThrows(IllegalArgumentException.class, () -> {
            Task t = new Task("qsdqsd","dab", LocalDateTime.of(3030,1,1,1,1));
            SubTask s = null;
            t.addSubTask(s);
        });

    }
}
