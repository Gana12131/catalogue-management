package com.backend.mastery.catalogue.management.controller;

import com.backend.mastery.catalogue.management.entity.Book;
import com.backend.mastery.catalogue.management.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name="Book API", description = "CRUD operations for managing book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @Operation(summary = "Get All Books", description = "Retrieve a list of all books in the catalogue")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved all books successful")})
    @GetMapping("/getAllBooks")
    ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Create a Book", description = "Create a Book to the catalogue")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book item saved successful")})
    @PostMapping("/save")
    ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    @Operation(summary = "Update the Book", description = "Update the Book to the catalogue")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book updated successful")})
    @PostMapping("/update/{id}")
    ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long id){
        return new ResponseEntity<>(bookService.update(id, book), HttpStatus.OK);
    }

    @Operation(summary = "Delete the Book", description = "Delete book from the catalogue")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book deleted successful")})
    @PostMapping("/delete/{id}")
    ResponseEntity<String> deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }
}
