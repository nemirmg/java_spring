package ru.gb.hw11.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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