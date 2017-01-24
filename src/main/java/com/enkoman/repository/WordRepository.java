package com.enkoman.repository;

import com.enkoman.model.entity.Word;
import com.enkoman.model.value.WordPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kolian on 2017. 1. 5..
 */
@Repository
public interface WordRepository extends JpaRepository<Word, WordPk>{
    void delete(WordPk wordPk);

}
