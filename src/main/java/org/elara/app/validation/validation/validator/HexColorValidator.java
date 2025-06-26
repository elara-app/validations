package org.elara.app.validation.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.elara.app.validation.validation.annotation.HexColor;

public class HexColorValidator implements ConstraintValidator<HexColor, String> {

    final static String HEX_COLOR_REGEX = "^(#([A-Fa-f0-9]{6}))";

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.matches(HEX_COLOR_REGEX);
    }

    public isBoolean isValidH(final String value, final ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.matches(HEX_COLOR_REGEX);
    }

}
