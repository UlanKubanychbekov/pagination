package com.example.pagination.controller;

import com.example.pagination.dto.PersonResponseView;
import com.example.pagination.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping
public class PersonApi {
    private final PersonService personService;

    @GetMapping
    public PersonResponseView getAll(@RequestParam(name = "text", required = false) String text,
                                     int page, int size){
        return personService.getAllPersons(text, page, size);
    }

}
