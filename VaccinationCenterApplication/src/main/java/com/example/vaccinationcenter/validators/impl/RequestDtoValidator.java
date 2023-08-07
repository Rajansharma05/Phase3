package com.example.vaccinationcenter.validators.impl;

import jakarta.validation.ConstraintValidatorContext;

public interface RequestDtoValidator<T> {
    boolean validate(T requestData, ConstraintValidatorContext context);
}
