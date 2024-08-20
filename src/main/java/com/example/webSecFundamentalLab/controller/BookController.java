package com.example.webSecFundamentalLab.controller;

import com.example.webSecFundamentalLab.model.BookModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @PostMapping({"", "/"})
    public ResponseEntity<?> addBook(@RequestBody @Valid BookModel book, BindingResult result) {
        try {
            if (result.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                result
                        .getAllErrors()
                        .forEach(
                                error -> errors.put(
                                        HtmlUtils.htmlEscape(((FieldError) error).getField()),
                                        HtmlUtils.htmlEscape(error.getDefaultMessage())
                                )
                        );
                Map<String, Map<String, String>> response = new HashMap<String, Map<String, String>>();
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

//        call a service to save the book

            return new ResponseEntity<>(HtmlUtils.htmlEscape("Created > , < , <body></body>, * /  "), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + "internal server error", HttpStatus.BAD_REQUEST);
        }

    }
}


