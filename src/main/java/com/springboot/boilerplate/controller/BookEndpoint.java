package com.springboot.boilerplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookEndpoint {

    @GetMapping
    @RequestMapping("/books")
    public List<Book> getBooks(){
        return List.of(new Book("Guardian of talons and snares","Anastasis Blythe"),
            new Book("The price of safety","Micahael C. Bland"),
            new Book("Our perfect murder","Camille Cabrera"));
    }
    
}

record Book (String name, String author){}
