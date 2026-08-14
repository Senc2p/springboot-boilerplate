package com.springboot.boilerplate.service;

import com.springboot.boilerplate.model.Books;
import com.springboot.boilerplate.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookPiler {

    private final BookRepository bookRepository;

    public BookPiler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> getBooks() {
        return bookRepository.findAll();
    }

    public Books addBook(Books newBook) {
        return bookRepository.save(newBook);
    }
}
