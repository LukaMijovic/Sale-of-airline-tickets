package com.diplomski.backend.external;

import jakarta.persistence.*;
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
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "calling_time")
    private LocalDateTime callingTime;
    @Column(name = "limit_value")
    private int limit;
    @Column(name = "offset_value")
    private int offset;
    @Column(name = "count_value")
    private int count;
    @Column(name = "total_value")
    private int total;
    private String message;
}
