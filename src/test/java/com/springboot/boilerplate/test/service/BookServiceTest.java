package com.springboot.boilerplate.test.service;

import com.springboot.boilerplate.model.Books;
import com.springboot.boilerplate.service.BookPiler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookPiler bookPiler;

    @Test
    void shouldReturnAllBook() {

        List<Books> list = bookPiler.getBooks();

        assertNotNull(list);
        assertEquals(3, list.size());

        assertEquals(1L, list.get(0).getId());
        assertEquals(2L, list.get(1).getId());
    }
}