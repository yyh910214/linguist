package com.enkoman.model.entity;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 단어장
 * Created by kolian on 2017. 1. 8..
 */
@Builder
@ToString
@Entity(name = "wordbooks")
public class WordBook {

    @Tolerate
    public WordBook() {}

    @Id
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Getter@Setter
    private String name;

    @Getter
    @Setter
    @Column(name = "public_yn", nullable = false)
    private boolean publicYn;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "wordbook_id")
    @Getter
    @Setter
    private Collection<Word> words;

    @Getter
    @Setter
    @Column(name = "reg_datetime", nullable = false, updatable = false)
    private LocalDateTime regDatetime;

    @Getter
    @Setter
    @Column(name = "mod_datetime", nullable = false)
    private LocalDateTime modDatetime;
}
