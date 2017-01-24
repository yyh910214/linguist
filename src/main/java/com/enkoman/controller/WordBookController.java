package com.enkoman.controller;

import com.enkoman.model.Result;
import com.enkoman.model.entity.WordBook;
import com.enkoman.service.WordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * WordBookController
 * Created by kolian on 2017. 1. 5..
 */
@RestController
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@RequestMapping(value = "/wordBooks")
public class WordBookController {
    @Autowired
    private WordBookService wordBookService;

    /**
     * 사용자의 단어장 목록 조회
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAllWordBooks(long userId, Pageable pageable) {
        return wordBookService.findWorkBookList(userId, pageable);
    }

    /**
     * 단어장 추가
     *
     * @param wordBook
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Result createWordBook(WordBook wordBook) {
        return wordBookService.createWordBook(wordBook);
    }

    /**
     * 단어장 정보 수정
     *
     * @param wordBook
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Result modifyWordBook(WordBook wordBook) {
        return wordBookService.modifyWordBook(wordBook);
    }

    /**
     * 단어장 삭제
     *
     * @param wordBookId
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public Result deleteWordBook(long wordBookId) {
        return wordBookService.removeWordBook(wordBookId);
    }
}
