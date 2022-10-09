package ru.evanli.moretech.tasks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.tasks.domain.AssignedTask;
import ru.evanli.moretech.tasks.domain.Task;
import ru.evanli.moretech.tasks.domain.dto.AssignedTaskDto;
import ru.evanli.moretech.tasks.repository.AssignedTaskRepository;
import ru.evanli.moretech.tasks.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignedTaskService {

    private final AssignedTaskRepository assignedTaskRepository;
    private final TaskRepository taskRepository;
    private final RemoteAuthService authService;

    @Transactional
    public void create(Long taskId) {
        Task task = taskRepository.getReferenceById(taskId);
        AssignedTask assignedTask = AssignedTask.builder()
            .userId(authService.getUserDetails().getId())
            .task(task)
            .status(AssignedTask.Status.ASSIGNED)
            .build();
        assignedTaskRepository.save(assignedTask);
    }

    @Transactional
    public void done(Long id) {

        Long userId = authService.getUserDetails().getId();

        AssignedTask assignedTask = assignedTaskRepository.findTopByUserIdAndId(userId, id);
        assignedTask.setStatus(AssignedTask.Status.DONE);
        assignedTaskRepository.save(assignedTask);
    }

    @Transactional(readOnly = true)
    public List<AssignedTaskDto> getAll() {

        Long userId = authService.getUserDetails().getId();

        return assignedTaskRepository.findByUserId(userId).stream()
            .map(
                at ->
                    AssignedTaskDto.builder()
                        .id(at.getId())
                        .task(at.getTask())
                        .userId(at.getUserId())
                        .status(at.getStatus())
                        .build()
            )
            .toList();
    }
}
