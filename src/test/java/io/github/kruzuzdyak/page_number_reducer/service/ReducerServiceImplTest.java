package io.github.kruzuzdyak.page_number_reducer.service;

import io.github.kruzuzdyak.page_number_reducer.dto.PageNumbersResponse;
import io.github.kruzuzdyak.page_number_reducer.service.impl.ReducerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test class for ReducerService")
public class ReducerServiceImplTest {

    private final ReducerService service = new ReducerServiceImpl();

    @DisplayName("Test reduce pages")
    @MethodSource("getRawPageNumbers")
    @ParameterizedTest
    public void testReducePages(String rawPageNumber, String reducedPageNUmber) {
        PageNumbersResponse expected = new PageNumbersResponse(rawPageNumber, reducedPageNUmber);

        PageNumbersResponse actual = service.reducePages(rawPageNumber);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getRawPageNumbers() {
        return Stream.of(
                Arguments.of("1,3,32,5,11,7,6,19,2,21,4,8,22,23", "1-8,11,19,21-23,32"),
                Arguments.of("26,27,25,1,3,2,4,10,20,7,8,6", "1-4,6-8,10,20,25-27"),
                Arguments.of("21,20,21,22,2,1,3,20,21,100,101,103,102,104,105", "1-3,20-22,100-105"),
                Arguments.of("5,3,1,6,8,10", "1,3,5,6,8,10"),
                Arguments.of("15,14,13,12,11,4,5,6,7,8,9,10", "4-15"),
                Arguments.of("20,16,10,11,12,13,4,4,4,20", "4,10-13,16,20"),
                Arguments.of("100,1000,10,1003,1001,1002,1000,1450", "10,100,1000-1003,1450"),
                Arguments.of("15,19,11,12,14,15,9,8,7","7-9,11,12,14,15,19"),
                Arguments.of("21,20,14,17,16,15,1,2,4,5,6,7","1,2,4-7,14-17,20,21"),
                Arguments.of("20,34,33,35,40,41,37,42","20,33-35,37,40-42")
        );
    }
}