package com.db_project.database.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // Needed for Jackson, bc Jackson creates an object with NoArgsConstructor
@Builder
public class AuthorDto {
    private Long id;

    private String name;

    private Integer age;
}
