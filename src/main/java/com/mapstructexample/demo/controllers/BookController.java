package com.mapstructexample.demo.controllers;

import com.mapstructexample.demo.mapstruct.dto.BookDto;
import com.mapstructexample.demo.mapstruct.mappers.MapStructMapper;
import com.mapstructexample.demo.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {

    private MapStructMapper mapStructMapper;
    private BookRepository bookRepository;

    @Autowired
    public BookController(MapStructMapper mapStructMapper, BookRepository bookRepository) {
        this.mapStructMapper = mapStructMapper;
        this.bookRepository = bookRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapStructMapper.bookToBookDto(bookRepository.findById(id).get()), HttpStatus.OK);
    }
}
