package org.elara.app.validation;

import jakarta.validation.Payload;
import org.elara.app.validation.validation.annotation.HexColor;
import org.elara.app.validation.validation.validator.HexColorValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ValidationApplicationTests {

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

    @Nested
    class WhenHexColorValidatorTests {
        HexColorValidator hexColorValidator = new HexColorValidator();

        @BeforeEach
        void init() {
            hexColorValidator.initialize(createAnnotation());
        }

        @Test
        void acceptsValidFullHexColor() {
            assertTrue(hexColorValidator.isValid("#1A2B3C", null));
        }

        @Test
        void acceptsNullValue() {
            assertTrue(hexColorValidator.isValid(null, null));
        }

        @Test
        void acceptsEmptyValue() {
            assertTrue(hexColorValidator.isValid("", null));
        }

        @Test
        void rejectsShorthandWithHash() {
            assertFalse(hexColorValidator.isValid("#123", null));
        }

        @Test
        void rejectsShorthandWithoutHash() {
            assertFalse(hexColorValidator.isValid("123", null));
        }

        @Test
        void rejectsWithoutHash() {
            assertFalse(hexColorValidator.isValid("1A2B3C", null));
        }

        @Test
        void rejectsInvalidCharacters() {
            assertFalse(hexColorValidator.isValid("#ZZZZZZ", null));
        }

    }

}
