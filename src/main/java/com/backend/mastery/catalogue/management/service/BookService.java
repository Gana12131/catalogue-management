package com.backend.mastery.catalogue.management.service;

import com.backend.mastery.catalogue.management.entity.Book;

import java.util.List;

public interface BookService {
    List<Book>  findAll();
    Book save(Book book);
    Book update(Long id, Book book);
    void delete(Long id);
}
