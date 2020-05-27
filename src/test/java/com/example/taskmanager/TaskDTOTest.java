package com.example.taskmanager;

import com.example.taskmanager.domain.SubTaskDTO;
import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
public class TaskDTOTest {

    @Test
    void transferFromTaskToTaskDTOWorks(){
        LocalDateTime date = LocalDateTime.of(3030,1,1,1,1);
        Task t = new Task("AZEAZE","AZEAZE", date);
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(t.getTitle());
        taskDTO.setId(t.getId());
        taskDTO.setDescription(t.getDescription());
        taskDTO.setDateTime(t.getDateTime());
        TaskDTO tastDTOTest = new TaskDTO("AZEAZE",date, "AZEAZE",new ArrayList<>(),t.getId());
        assertEquals(taskDTO.getTitle(),tastDTOTest.getTitle());
        assertEquals(taskDTO.getDateTime(),tastDTOTest.getDateTime());
        assertEquals(taskDTO.getDescription(),tastDTOTest.getDescription());
    }

}
