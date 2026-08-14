package com.springboot.boilerplate.test.service;
import com.springboot.boilerplate.controller.BookEndpoint;
import com.springboot.boilerplate.model.Books;
import com.springboot.boilerplate.service.BookPiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(BookEndpoint.class)
public class AddingBookTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookPiler bookPiler;

    @Test
    void shouldAddNewBook() throws Exception {
        Books newBook = new Books(
                4L,
                "The Good, The Bad, The Ugly",
                "Naruto Uzumaki"
        );

        when(bookPiler.addBook(any(Books.class))).thenReturn(newBook);

        mockMvc.perform(post("/api/addBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                {
                    "id": 4,
                    "name": "The Good, The Bad, The Ugly",
                    "author": "Naruto Uzumaki"
                }
                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("The Good, The Bad, The Ugly"))
                .andExpect(jsonPath("$.author").value("Naruto Uzumaki"));
    }

}
