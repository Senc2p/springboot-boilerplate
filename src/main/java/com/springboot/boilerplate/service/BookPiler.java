package com.springboot.boilerplate.service;

import com.springboot.boilerplate.model.Books;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookPiler {

    public static List<Books> getBooks() {
        return List.of(
                new Books(1L, "Bulan", "Tere Lise"),
                new Books(2L, "Matahari", "Tere Lise")
        );
    }
}
