package com.enkoman.model;

import com.enkoman.type.ResultCode;
import lombok.*;

/**
 * Result for response
 * Created by kolian on 2017. 1. 8..
 */
@ToString
@Builder
public class Result {
    @Getter @Setter
    private ResultCode resultCode;
    @Getter @Setter
    private String message;
    @Getter @Setter
    private Object body;
}
