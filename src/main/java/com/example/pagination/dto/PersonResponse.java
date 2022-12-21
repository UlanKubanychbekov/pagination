package com.example.pagination.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * author: Ulansky
 */

@Getter
@Setter
public class PersonResponse {
    private Long id;

    private String name;

    private String email;

    private int age;
}
