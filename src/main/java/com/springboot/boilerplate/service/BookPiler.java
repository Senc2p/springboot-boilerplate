package com.springboot.boilerplate.service;

import com.springboot.boilerplate.model.Books;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookPiler {

    private List<Books> books = new ArrayList<>(List.of(
            new Books(10L, "Guardian of talons and snares", "Anastasis Blythe"),
            new Books(15L, "The price of safety", "Micahael C. Bland"),
            new Books(20L, "Our perfect murder", "Camille Cabrera")
    ));

    public List<Books> getBooks() {
        return books;
    }

    public Books addBook(Books newBook) {
        books.add(newBook);
        return newBook;
    }
}
