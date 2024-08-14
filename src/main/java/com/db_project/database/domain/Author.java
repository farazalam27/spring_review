package com.db_project.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    // Use capital Long instead of long bc it can potentially be null, same with Integer
    private Long id;
    private String name;
    private Integer age;
}
