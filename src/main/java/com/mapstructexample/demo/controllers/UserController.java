package com.mapstructexample.demo.controllers;

import com.mapstructexample.demo.mapstruct.dto.UserGetDto;
import com.mapstructexample.demo.mapstruct.dto.UserPostDto;
import com.mapstructexample.demo.mapstruct.mappers.MapStructMapper;
import com.mapstructexample.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private MapStructMapper mapStructMapper;
    private UserRepository userRepository;

    @Autowired
    public UserController(MapStructMapper mapStructMapper, UserRepository userRepository) {
        this.mapStructMapper = mapStructMapper;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity <Void> create(@Valid @RequestBody UserPostDto userPostDto) {
        userRepository.save(mapStructMapper.userPostDtoToUser(userPostDto));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(mapStructMapper.userToUserGetDto(userRepository.findById(id).get()), HttpStatus.OK);
    }
}
