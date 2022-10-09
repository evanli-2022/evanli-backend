package ru.evanli.moretech.tasks.domain.dto;

import lombok.Builder;
import lombok.Data;
import ru.evanli.moretech.tasks.domain.AssignedTask;
import ru.evanli.moretech.tasks.domain.Task;

@Data
@Builder
public class AssignedTaskDto {
    private Long id;
    private Task task;
    private Long userId;
    private AssignedTask.Status status;
}
