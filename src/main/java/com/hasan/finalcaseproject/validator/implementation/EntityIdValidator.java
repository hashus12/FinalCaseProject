package com.hasan.finalcaseproject.validator.implementation;

import com.hasan.finalcaseproject.exception.BaseValidationException;
import com.hasan.finalcaseproject.exception.ValidationOperationException;
import com.hasan.finalcaseproject.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class EntityIdValidator implements Validator<Long, String> {

    @Override
    public void validate(Long input, String name) throws BaseValidationException {
        if (input < 0) {
            throw new ValidationOperationException.IdNotValidator(name + " not found!");
        }
    }
}