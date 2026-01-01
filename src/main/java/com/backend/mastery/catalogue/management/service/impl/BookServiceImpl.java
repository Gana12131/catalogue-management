package com.backend.mastery.catalogue.management.service.impl;

import com.backend.mastery.catalogue.management.entity.Book;
import com.backend.mastery.catalogue.management.repository.BookRepository;
import com.backend.mastery.catalogue.management.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book){
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
