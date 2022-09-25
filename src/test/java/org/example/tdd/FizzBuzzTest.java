package org.example.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // If number is divisible by 3, print Fizz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5, print FizzBuzz
    // If number is NOT divisible by 3 or 5, print number

    @Test
    @Order(1)
    void number_is_divisible_by_3() {
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @Test
    @Order(2)
    void number_is_divisible_by_5() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(10), "Should return Buzz");
    }

    @Test
    @Order(3)
    void number_is_divisible_by_3_and_5() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");

    }

    @Test
    @Order(4)
    void number_is_NOT_divisible_by_3_or_5() {
        int number = 4;
        String expected = Integer.toString(number);
        assertEquals(expected, FizzBuzz.compute(number), String.format("Should print %s", expected));

    }

    @ParameterizedTest(name = "value={0}, expected{1}")
    @Order(5)
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, Fizz",
            "4, 4",
            "5, Buzz",
            "6, Fizz",
            "7, 7",
            "15, FizzBuzz"
    })
    void test_with_CSV_data(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));

    }


    @ParameterizedTest(name = "value={0}, expected{1}")
    @Order(6)
    @CsvFileSource(resources = "/small-test-data.csv")
    void test_with_small_CSV_file(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));

    }

    @ParameterizedTest(name = "value={0}, expected{1}")
    @Order(7)
    @CsvFileSource(resources = "/medium-test-data.csv")
    void test_with_medium_CSV_file(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));

    }

    @ParameterizedTest(name = "value={0}, expected{1}")
    @Order(8)
    @CsvFileSource(resources = "/large-test-data.csv")
    void test_with_large_CSV_file(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));

    }
}
