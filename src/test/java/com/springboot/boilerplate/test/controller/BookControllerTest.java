package com.springboot.boilerplate.test.controller;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookEndpoint.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookPiler bookPiler;

    @Test
    void shouldReturnAllBooks() throws Exception {
        List<Books> books = List.of(
                new Books(10L,"Guardian of talons and snares","Anastasis Blythe")
        );

        when(bookPiler.getBooks()).thenReturn(books);

        mockMvc.perform(get("/api/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("Guardian of talons and snares"))
                .andExpect(jsonPath("[0].author").value("Anastasis Blythe"));

    }
}
