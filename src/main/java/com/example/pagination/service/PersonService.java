package com.example.pagination.service;

import com.example.pagination.dto.PersonResponse;
import com.example.pagination.dto.PersonResponseView;
import com.example.pagination.entity.Person;
import com.example.pagination.mapper.ViewMapper;
import com.example.pagination.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final ViewMapper viewMapper;

 public PersonResponseView getAllPersons(String text, int page, int size){
     Pageable pageable = PageRequest.of(page, size);
     PersonResponseView personResponseView = new PersonResponseView();
     personResponseView.setPersonResponses(view(search(text,pageable)));
     return personResponseView;
 }
 public List <PersonResponse> view (List<Person> people){
     List<PersonResponse> personResponses = new ArrayList<>();
     for(Person p : people){
         personResponses.add(viewMapper.personResponses(p));
     }
     return personResponses;
 }
 public List<Person> search(String name, Pageable pageable){
     String text = name == null ? "":name;
    return repository.searchPagination(text,pageable);

 }
}
