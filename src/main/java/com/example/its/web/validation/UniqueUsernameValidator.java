package com.example.its.web.validation;

import com.example.its.domain.auth.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext Context) {
        //findByUsernameでユーザー名を検索して、存在しないとtrueとなるメソッド
        return userRepository.findByUsername(value).isEmpty();
    }
}
