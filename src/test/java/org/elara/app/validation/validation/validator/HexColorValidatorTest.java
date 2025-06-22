package org.elara.app.validation.validation.validator;

import jakarta.validation.Payload;
import org.elara.app.validation.validation.annotation.HexColor;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class HexColorValidatorTest {

    private HexColor createAnnotation() {
        return new HexColor() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return "";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }
        };
    }

}