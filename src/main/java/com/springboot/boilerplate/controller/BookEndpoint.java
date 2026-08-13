package com.springboot.boilerplate.controller;

import com.springboot.boilerplate.model.Books;
import com.springboot.boilerplate.service.BookPiler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookEndpoint {

    private final BookPiler bookPiler = new BookPiler();

    @GetMapping("/books")
    public List<Books> getFixedBooks(){
        return List.of(new Books(10L,"Guardian of talons and snares","Anastasis Blythe"),
            new Books(15L,"The price of safety","Micahael C. Bland"),
            new Books(20L,"Our perfect murder","Camille Cabrera"));
    }

    @GetMapping("/seeBooks")
    public List<Books> getBooks(){
        return bookPiler.getBooks();
    }

}

record Book (String name, String author){}
