package org.itstep.booklibrary.controller;

import org.itstep.booklibrary.exception.BookNotFoundException;
import org.itstep.booklibrary.model.Book;
import org.itstep.booklibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
//        return bookRepository.findByTitle(bookTitle);
        return bookRepository.findAllBooksByTitleContains(bookTitle);
    }

//    @GetMapping("/genre/{genre}")
//    public List<Book> findByGenre(@PathVariable Genre genre) {
////        return bookRepository.findByTitle(bookTitle);
//        return bookRepository.findAllBooksByGenresContains(genre);
//    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @GetMapping
    public List<Book> retrieveAllBooks() {
        return (List) bookRepository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
        return;
    }


}