package org.itstep.booklibrary.controller;

import org.itstep.booklibrary.exception.BookNotFoundException;
import org.itstep.booklibrary.model.Genre;
import org.itstep.booklibrary.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;


    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    @GetMapping("/value/{bookGenre}")
    public List<Genre> findByGenre(@PathVariable String bookGenre) {
        return genreRepository.findByValue(bookGenre);
    }

    @GetMapping("/{id}")
    public Genre findOne(@PathVariable Long id) {
        return genreRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
    @GetMapping
    public List<Genre> retrieveAllGenres() {
        return (List) genreRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        genreRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        genreRepository.deleteById(id);
        return;
    }


    @PutMapping
    public Genre updateGenre(@RequestBody Genre genre, @PathVariable Long id) {
        if(genre.getId() != id) {
            throw new RuntimeException();
        }
        genreRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return genreRepository.save(genre);
    }
}
