package com.example.webSecFundamentalLab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Ensure you've submitted title")
    @Size(min = 3, message = "A valid title should be above 3 characters")
    private String title;

    @NotBlank(message = "Ensure you've submitted a description for the book")
    @Size(min = 3, message = "A valid description should be above 3 characters")
    private String description;

    @Min(0)
    private int numberOfBooks;

    @Past(message = "Ensure that you've submitted a date that is in the past")
    private Date publishedDate;

    @NotBlank
    @Email(message = "Ensure you've submitted a valid email")
    private String email;
}
