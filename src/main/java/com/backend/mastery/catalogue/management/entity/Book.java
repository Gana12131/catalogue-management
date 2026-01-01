package com.backend.mastery.catalogue.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String isbnNumber;
    private LocalDate publishDate;
    private Double price;

    @Enumerated(EnumType.STRING)
    private BookType bookType;


}
