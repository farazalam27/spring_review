package com.db_project.database.services.impl;

import com.db_project.database.domain.entities.BookEntity;
import com.db_project.database.repositories.BookRepository;
import com.db_project.database.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport
                .stream(
                    bookRepository.findAll().spliterator(),
                    false)
                .collect(Collectors.toList());
    }
}
