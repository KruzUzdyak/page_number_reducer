package io.github.kruzuzdyak.page_number_reducer.validation.impl;

import io.github.kruzuzdyak.page_number_reducer.validation.annotation.RawPageNumbers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class RawPageNumbersConstraint implements ConstraintValidator<RawPageNumbers, String> {

    private static final String PAGE_NUMBER_PATTERN = "\\s*([1-9]\\d*)\\s*(,\\s*[1-9]\\d*\\s*)*";

    @Override
    public void initialize(RawPageNumbers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Optional.ofNullable(value)
                .filter(string -> !string.isBlank())
                .map(string -> string.matches(PAGE_NUMBER_PATTERN))
                .orElse(false);
    }
}
