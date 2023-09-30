package org.itstep.booklibrary.repository;

import org.itstep.booklibrary.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findByValue(String genre);
}
