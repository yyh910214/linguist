package com.enkoman.model.value;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by kolian on 2017. 1. 22..
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WordPk implements Serializable {
    @Getter
    private String word;

    @Getter
    private String wordBookId;
}