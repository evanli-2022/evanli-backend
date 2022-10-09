package ru.evanli.moretech.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "tasks", name = "assigned")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignedTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = Task.class)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public enum Status {
        ASSIGNED,
        DONE;
    }
}
