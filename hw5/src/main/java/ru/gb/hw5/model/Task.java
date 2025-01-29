package ru.gb.hw5.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
@Data
@NoArgsConstructor
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="description", nullable=false)
    private String description;

    @Enumerated(value=EnumType.STRING)
    @JsonProperty(value="status")
    private Status status;

    private LocalDateTime createAt;

    private LocalDateTime changesAt;
}
