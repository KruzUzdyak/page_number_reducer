package io.github.kruzuzdyak.page_number_reducer.validation.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test class for RawPageNumbersConstraint")
public class RawPageNumbersConstraintTest {

    private final RawPageNumbersConstraint constraint = new RawPageNumbersConstraint();

    @DisplayName("Test validation for raw page numbers")
    @MethodSource("getRawPageNumbers")
    @ParameterizedTest
    public void testValidation(String rawPageNumbers, boolean expected) {
        boolean actual = constraint.isValid(rawPageNumbers, null);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getRawPageNumbers() {
        return Stream.of(
                Arguments.of("1,3,32,5,11,7,6,19,2,21,4,8,22,23", true),
                Arguments.of(" 1 , 10, 20 , 100", true),
                Arguments.of("100000000", true),
                Arguments.of("", false),
                Arguments.of("abcd", false),
                Arguments.of("1234abc", false),
                Arguments.of("0, 01, 02", false),
                Arguments.of("-1, -2, -3", false),
                Arguments.of("1,", false),
                Arguments.of(",1", false),
                Arguments.of(null, false),
                Arguments.of("   ", false)
        );
    }
}