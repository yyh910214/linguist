package com.enkoman.service;

import com.enkoman.model.Result;
import com.enkoman.model.entity.WordBook;
import com.enkoman.repository.WordBookRepository;
import com.enkoman.type.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

/**
 * Created by kolian on 2017. 1. 8..
 */
@Service
public class WordBookService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordBookService.class);

    @Autowired
    WordBookRepository wordBookRepository;

    @Autowired
    MessageSource messageSource;

    /**
     * Get wordbook list
     * @param userId
     * @param pageable
     * @return
     */
    public Result findWorkBookList(long userId, Pageable pageable) {
        List<WordBook> wordBooks = wordBookRepository.findByUserId(userId, pageable);
        return Result.builder().resultCode(ResultCode.SUCESS).body(wordBooks).build();
    }

    /**
     * 단어장 생성
     *
     * @param wordBookParam
     * @return
     */
    public Result createWordBook(WordBook wordBookParam) {
        wordBookParam.setRegDatetime(LocalDateTime.now());
        wordBookParam.setModDatetime(LocalDateTime.now());
        WordBook wordBook = wordBookRepository.save(wordBookParam);
        return Result.builder().body(wordBook).resultCode(ResultCode.SUCESS).build();
    }

    /**
     * 단어장 id로 단어장 삭제
     *
     * @param wordBookId
     * @return
     */
    public Result removeWordBook(long wordBookId) {
        long deletedRow = wordBookRepository.deleteById(wordBookId);
        if (deletedRow != 1) {
            return Result.builder().resultCode(ResultCode.ERROR).body(deletedRow).build();
        }

        return Result.builder().resultCode(ResultCode.SUCESS).body(wordBookId).build();
    }

    /**
     * 단어장 정보 수정
     *
     * @param wordBookParam
     * @return
     */
    public Result modifyWordBook(WordBook wordBookParam) {
        WordBook wordBook = wordBookRepository.findById(wordBookParam.getId());
        if (wordBook == null) {
            return Result.builder().resultCode(ResultCode.ERROR).message(messageSource.getMessage("error.not.found.wordbook", null, Locale.KOREA)).build();
        }

        wordBookRepository.saveAndFlush(wordBookParam);
        return Result.builder().resultCode(ResultCode.SUCESS).body(wordBookParam).build();
    }
}
