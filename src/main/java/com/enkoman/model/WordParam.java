package com.enkoman.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * Created by kolian on 2017. 1. 5..
 */
@EqualsAndHashCode
@ToString
public class WordParam {
    @Getter @Setter
    private String word;
    @Getter @Setter
    private Set<String> definitions;
}
