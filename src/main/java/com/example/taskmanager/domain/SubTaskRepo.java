package com.example.taskmanager.domain;

import com.example.taskmanager.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubTaskRepo extends JpaRepository<SubTask, Long> {
}
