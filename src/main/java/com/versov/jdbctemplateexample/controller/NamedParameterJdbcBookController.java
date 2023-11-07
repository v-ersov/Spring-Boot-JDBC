package com.versov.jdbctemplateexample.controller;

import com.versov.jdbctemplateexample.model.Book;
import com.versov.jdbctemplateexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("named-parameter-jdbc/books")
@RequiredArgsConstructor
public class NamedParameterJdbcBookController {

    private final BookRepository namedParameterJdbcTemplateBookRepository;

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable("id") Long id) {
        return namedParameterJdbcTemplateBookRepository.findById(id);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Book book) {
        return namedParameterJdbcTemplateBookRepository.update(book);
    }

    @GetMapping("/name/{name}/price/{price}")
    public List<Book> findByNameAndPrice(@PathVariable("name") String name, @PathVariable("price") BigDecimal price) {
        return namedParameterJdbcTemplateBookRepository.findByNameAndPrice(name, price);
    }
}
