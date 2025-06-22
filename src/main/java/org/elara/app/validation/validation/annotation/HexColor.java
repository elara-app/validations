package org.elara.app.validation.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.elara.app.validation.validation.validator.HexColorValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = HexColorValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface HexColor {

    String message() default "Invalid hex color format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
