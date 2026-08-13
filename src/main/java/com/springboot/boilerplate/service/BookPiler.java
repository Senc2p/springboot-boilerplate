package com.springboot.boilerplate.service;

import com.springboot.boilerplate.model.Books;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookPiler {

    public List<Books> getBooks() {
        return List.of(new Books(10L,"Guardian of talons and snares","Anastasis Blythe"),
                new Books(15L,"The price of safety","Micahael C. Bland"),
                new Books(20L,"Our perfect murder","Camille Cabrera")
        );
    }
}
