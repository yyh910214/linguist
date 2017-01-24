package com.enkoman.model.entity;

import com.enkoman.model.value.DefinitionSet;
import com.enkoman.model.value.WordPk;
import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 단어
 * Created by kolian on 2017. 1. 5..
 */
@Builder
@ToString
@Entity(name = "wordbook_word")
@IdClass(WordPk.class)
public class Word {

    @Tolerate
    public Word() {}

    @Id
    @Column(name = "word")
    @Getter
    @Setter
    private String word;

    @Id
    @Column(name = "wordbook_id")
    @Getter
    @Setter
    private String wordBookId;

    @Column(name = "definitions")
    @Convert(converter = DefinitionSet.DefinitionSetConverter.class)
    @Getter
    @Setter
    private DefinitionSet definitionSet;

    @Getter
    @Setter
    @Column(name = "reg_datetime", nullable = false, updatable = false)
    private LocalDateTime regDateTime = LocalDateTime.now();

    @Getter
    @Setter
    @Column(name = "mod_datetime", nullable = false, updatable = false)
    private LocalDateTime modDateTime = LocalDateTime.now();
}
