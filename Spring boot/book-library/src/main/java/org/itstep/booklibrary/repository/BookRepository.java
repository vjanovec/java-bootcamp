package org.itstep.booklibrary.repository;


import org.itstep.booklibrary.model.Book;
import org.itstep.booklibrary.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findAllBooksByTitleContains(String contains);
    List<Book> findAllBooksByGenresContains(Genre genres);

}