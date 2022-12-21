package com.example.pagination.repository;

import com.example.pagination.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query("select p from Person p where upper(p.name) like concat('%', :pagination, '%') or upper(p.email) like concat('%', :pagination, '%') ")
    List<Person> searchPagination(@Param("pagination") String pagination, Pageable pageable);
}
