package com.enkoman.service;

import com.enkoman.model.Result;
import com.enkoman.model.entity.Word;
import com.enkoman.model.value.WordPk;
import com.enkoman.repository.WordRepository;
import com.enkoman.type.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kolian on 2017. 1. 16..
 */
@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    /**
     * 단어 저장
     *
     * @param wordParam
     * @return
     */
    public Result addWord(Word wordParam) {
        wordRepository.save(wordParam);
        return Result.builder().body(wordParam).resultCode(ResultCode.SUCESS).build();
    }

    public Result removeWord(WordPk wordPk) {
        wordRepository.delete(wordPk);
        return Result.builder().body(wordPk).resultCode(ResultCode.SUCESS).build();
    }
}
