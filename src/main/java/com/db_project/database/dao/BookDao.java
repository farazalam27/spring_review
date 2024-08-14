package com.db_project.database.dao;

import com.db_project.database.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    //Return an optional so we don't get null, we get optional empty if there is no author, more type safe
    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(String isbn, Book book);

    void delete(String isbn);
}
