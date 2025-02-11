package com.example.crud_apis.controller;

import com.example.crud_apis.dto.UserCreateDto;
import com.example.crud_apis.dto.UserDto;
import com.example.crud_apis.dto.UserShortDto;
import com.example.crud_apis.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<UserDto> getAll() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/afm/{afm}")
    public UserDto getByAfm(@PathVariable String afm) {
        return userService.findByAfm(afm);
    }

    @GetMapping("/{id}/short")
    public UserShortDto getByIdNameOnly(@PathVariable Long id) {
        return userService.findByIdNameOnly(id);
    }

    @PostMapping()
    public UserCreateDto create(@Valid @RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto);
    }

    @PutMapping()
    public UserDto update(@Valid @RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}















