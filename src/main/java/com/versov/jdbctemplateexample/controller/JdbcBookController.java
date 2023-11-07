package com.versov.jdbctemplateexample.controller;

import com.versov.jdbctemplateexample.model.Book;
import com.versov.jdbctemplateexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("jdbc/books")
@RequiredArgsConstructor
public class JdbcBookController {

    private final BookRepository jdbcTemplateBookRepository;

    @GetMapping
    public List<Book> findAllBooks() {
        return jdbcTemplateBookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable("id") Long id) {
        return jdbcTemplateBookRepository.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return jdbcTemplateBookRepository.count();
    }

    @PostMapping
    public int save(@RequestBody Book book) {
        return jdbcTemplateBookRepository.save(book);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Book book) {
        return jdbcTemplateBookRepository.update(book);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable("id") Long id) {
        return jdbcTemplateBookRepository.deleteById(id);
    }

    @GetMapping("/name/{name}/price/{price}")
    public List<Book> findByNameAndPrice(@PathVariable("name") String name, @PathVariable("price") BigDecimal price) {
        return jdbcTemplateBookRepository.findByNameAndPrice(name, price);
    }
}
