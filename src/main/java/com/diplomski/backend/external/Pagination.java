package com.diplomski.backend.external;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagination")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private Long id;
    @Column(name = "calling_time")
    private LocalDateTime callingTime;
    private int limit;
    private int offset;
    private int count;
    private int total;
    private String message;
}
