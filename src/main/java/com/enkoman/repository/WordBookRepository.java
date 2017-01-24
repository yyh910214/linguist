package com.enkoman.repository;

import com.enkoman.model.entity.WordBook;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kolian on 2017. 1. 8..
 */

@Repository
public interface WordBookRepository extends JpaRepository<WordBook, String> {
    Long deleteById(long wordBookId);
    WordBook findById(long wordBookId);
    List<WordBook> findByUserId(long userId, Pageable pageable);
}
