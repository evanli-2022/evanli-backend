package ru.evanli.moretech.tasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evanli.moretech.tasks.domain.dto.AssignedTaskDto;
import ru.evanli.moretech.tasks.service.AssignedTaskService;

import java.util.List;

@RestController
@RequestMapping("/api/assigned-tasks")
@RequiredArgsConstructor
public class AssignedTaskController {

    private final AssignedTaskService assignedTaskService;

    @GetMapping
    public List<AssignedTaskDto> getAll() {
        return assignedTaskService.getAll();
    }

    @PostMapping
    public void create(Long taskId) {
        assignedTaskService.create(taskId);
    }

    @PutMapping("/{assignedTaskId}")
    public void done(@PathVariable Long assignedTaskId) {
        assignedTaskService.done(assignedTaskId);
    }
}
