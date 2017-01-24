package com.enkoman.controller;

import com.enkoman.model.Result;
import com.enkoman.model.WordParam;
import com.enkoman.model.entity.Word;
import com.enkoman.model.value.WordPk;
import com.enkoman.repository.WordRepository;
import com.enkoman.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kolian on 2017. 1. 5..
 */
@RestController
@RequestMapping(value="/wordBooks/{wordBookId}/words")
@EnableAutoConfiguration
public class WordController {

    @Autowired
    private WordService wordService;

    @Autowired
    private WordRepository wordRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Word> findAllWords() {
        return wordRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result addWord(@PathVariable("wordBookId") String wordBookId, Word wordParam) {
        wordParam.setWordBookId(wordBookId);
        return wordService.addWord(wordParam);
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.DELETE)
    public Result removeWords(@PathVariable("wordBookId") String wordBookId, @PathVariable(name = "word")String word) {
        return wordService.removeWord(new WordPk(word, wordBookId));
    }
}
