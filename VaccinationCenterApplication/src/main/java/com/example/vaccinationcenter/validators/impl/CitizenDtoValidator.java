package com.example.vaccinationcenter.validators.impl;

import com.example.vaccinationcenter.dtos.CitizenDto;
import com.example.vaccinationcenter.validators.antn.CitizenValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class CitizenDtoValidator implements ConstraintValidator<CitizenValidator, CitizenDto> {

    @Override
    public boolean isValid(CitizenDto dto, ConstraintValidatorContext context) {
        return getRequestDtoValidator(dto).validate(dto, context);
    }

    @Override
    public void initialize(CitizenValidator constraintAnnotation) {
    }

    private static RequestDtoValidator<CitizenDto> getRequestDtoValidator(CitizenDto dto) {
        if (dto == null) return null;

        if (dto.getHttpMethod().equalsIgnoreCase("post")) {
            return new PostRequestValidator();
        } else if (dto.getHttpMethod().equalsIgnoreCase("put")) {
            return new PutRequestValidator();
        }

        return null;
    }

    private static class PostRequestValidator implements RequestDtoValidator<CitizenDto> {
        @Override
        public boolean validate(CitizenDto citizen, ConstraintValidatorContext context) {
            boolean flag = true;

            if (citizen == null) {
                flag = false;
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Citizen details required")
                    .addPropertyNode("citizen")
                    .addConstraintViolation();
                return flag;
            }

            if (StringUtils.isBlank(citizen.getName())) {
                flag = false;
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Citizen name required")
                    .addPropertyNode("name")
                    .addConstraintViolation();
            }

            if (!(citizen.getName().length() > 2 && citizen.getName().length() < 30)) {
                flag = false;
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Citizen name should be between 2 and 30 characters in length")
                    .addPropertyNode("name")
                    .addConstraintViolation();
            }

            // Similar validation for other fields...

            return flag;
        }
    }

    private static class PutRequestValidator extends PostRequestValidator {
        @Override
        public boolean validate(CitizenDto citizen, ConstraintValidatorContext context) {
            boolean flag = super.validate(citizen, context);

            if (citizen.getDoesCount() > 2 || citizen.getDoesCount() < 0) {
                flag = false;
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Citizen vaccine count should be between 0 and 2")
                    .addPropertyNode("doesCount")
                    .addConstraintViolation();
            }

            // Similar validation for other fields...

            return flag;
        }
    }
}
