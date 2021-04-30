package com.mapstructexample.demo.controllers;

import com.mapstructexample.demo.mapstruct.dto.AuthorAllDto;
import com.mapstructexample.demo.mapstruct.dto.AuthorDto;
import com.mapstructexample.demo.mapstruct.mappers.MapStructMapper;
import com.mapstructexample.demo.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private MapStructMapper mapStructMapper;
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(MapStructMapper mapStructMapper, AuthorRepository authorRepository) {
        this.mapStructMapper = mapStructMapper;
        this.authorRepository = authorRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity <AuthorDto> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapStructMapper.authorToAuthorDto(authorRepository.findById(id).get()), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List <AuthorAllDto>> getAll(){
        return new ResponseEntity<>(mapStructMapper.authorsToAuthorAllDtos(authorRepository.findAll()),HttpStatus.OK);
    }
}
