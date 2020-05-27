package com.example.taskmanager;

import com.example.taskmanager.domain.SubTask;
import com.example.taskmanager.domain.SubTaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SubTaskDTOTests {

    @Test
    void testSubTaskDTOTransfer(){
        SubTask s = new SubTask("ksjdkfjsd","sljkjdfsjdf");
        SubTaskDTO stdo = new SubTaskDTO(s.getTitle(),s.getDescription());
        assertEquals(stdo.getDescription(),s.getDescription());
        assertEquals(stdo.getTitle(),s.getTitle());
        assertEquals(s.getDescription(),SubTaskDTO.toSubTask(stdo).getDescription());
        UUID id = UUID.randomUUID();
        stdo.setId(id);
        assertEquals(id,stdo.getId());

    }
}
