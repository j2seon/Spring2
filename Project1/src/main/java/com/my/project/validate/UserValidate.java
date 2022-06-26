package com.my.project.validate;

import com.my.project.domain.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;

        String id = user.getId();


    }
}
