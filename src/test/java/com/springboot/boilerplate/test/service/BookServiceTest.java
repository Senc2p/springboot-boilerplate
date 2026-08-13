package com.springboot.boilerplate.test.service;

import com.springboot.boilerplate.model.Books;
import com.springboot.boilerplate.service.BookPiler;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private final BookPiler books = new BookPiler();

    @Test
    void shouldReturnAllBook() {
        List<Books> list = books.getBooks();

        assertNotNull(list);
        assertEquals(3, list.size());

         assertEquals(10L,list.get(0).getId());
         assertEquals(15L,list.get(1).getId());
    }
}
