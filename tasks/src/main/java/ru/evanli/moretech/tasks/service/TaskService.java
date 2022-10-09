package ru.evanli.moretech.tasks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evanli.moretech.tasks.repository.TaskRepository;
import ru.evanli.moretech.tasks.domain.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task getById(Long id) {
        return taskRepository.getReferenceById(id);

    }

}
