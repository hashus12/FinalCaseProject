package com.hasan.finalcaseproject.validator;

import com.hasan.finalcaseproject.exception.BaseValidationException;

public interface Validator<T,K> {
    void validate(T input, K name) throws BaseValidationException;

}
