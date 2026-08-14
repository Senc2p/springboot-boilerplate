package com.springboot.boilerplate.controller;

import com.springboot.boilerplate.model.Books;
import com.springboot.boilerplate.service.BookPiler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookEndpoint {

    private final BookPiler bookPiler;

    @GetMapping("/books")
    public List<Books> getBooks() {
        return bookPiler.getBooks();
    }

    @PostMapping("/addBook")
    public Books addBook(@RequestBody Books newBook) {
        return bookPiler.addBook(newBook);
    }
}