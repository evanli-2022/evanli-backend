package ru.evanli.moretech.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evanli.moretech.tasks.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
