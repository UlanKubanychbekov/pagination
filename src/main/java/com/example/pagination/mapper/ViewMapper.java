package com.example.pagination.mapper;

import com.example.pagination.dto.PersonResponse;
import com.example.pagination.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author: Ulansky
 */
@Component
public class ViewMapper {

  public PersonResponse personResponses(Person people){
      if(people == null){
       return null;
      }
      PersonResponse personResponse = new PersonResponse();
      personResponse.setId(people.getId());
      personResponse.setName(people.getName());
      personResponse.setEmail(people.getEmail());
      personResponse.setAge(people.getAge());
      return personResponse;
  }

}
