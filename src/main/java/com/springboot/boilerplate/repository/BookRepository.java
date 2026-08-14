package com.springboot.boilerplate.repository;

import com.springboot.boilerplate.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {

}
