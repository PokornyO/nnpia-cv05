package com.example.nnpiacv02.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Date creation_date;
    private Date update_date;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    @JsonIgnore
    private AppUser appUser;
}
