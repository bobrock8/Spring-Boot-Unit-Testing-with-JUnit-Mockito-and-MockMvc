package org.example.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    @DisplayName("@BeforeAll")
    static void beforeAll() {
    }

    @AfterAll
    @DisplayName("@AfterAll")
    static void afterAll() {
    }

    @BeforeEach
    @DisplayName("@BeforeEach")
    void setup() {
        demoUtils = new DemoUtils();
    }

    @AfterEach
    @DisplayName("@AfterEach")
    void cleanup() {
    }

    @Test
    @DisplayName("Running test: Equals and Non Equals")
    @Disabled("Don't run test")
    void testEqualsAndNotEquals() {

        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Running test: Null and Non Null")
    @Order(3)
    @EnabledOnOs(OS.LINUX)
    void testEqualsNullOrEqualsNotNull() {

        System.out.println("Running test: testEqualsNullOrEqualsNotNull");


        String someString = "some string";
        Integer someInt = 99;
        String nullString = null;

        assertNull(demoUtils.checkObjectIsNull(nullString), "object is not null");
        assertNotNull(demoUtils.checkObjectIsNull(someInt), "Integer can not be null");
        assertNotNull(demoUtils.checkObjectIsNull(someString), "String can not be null");
    }


    @Test
    @DisplayName("Same and not same")
    @Order(-1)
    @EnabledOnJre(JRE.JAVA_17)
    void test_same_and_not_the_same() {

        String someOtherString = "some other string for testing";

        assertSame(demoUtils.getTestString(), demoUtils.getTestStringDuplicate(), "should be the same");
        assertNotSame(demoUtils.getTestString(), someOtherString, "should be not the same");
    }

    @Test
    @DisplayName("True or False")
    @Order(1)
    @EnabledOnJre(JRE.JAVA_13)
    void test_true_or_false() {

        Integer num1 = 50;
        Integer num2 = 10;
        Integer num3 = 20;

        assertTrue(demoUtils.isGreater(num1, num2), "should be true: 50 is greater than 10");
        assertFalse(demoUtils.isGreater(num2, num3), "should be true: 10 is not greater than 20");

    }


    @Test
    @DisplayName("Array Equals")
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
    void test_array_equals() {


        String[] firstThreeAlphabet = {"A", "B", "C"};
        // String[] someAlphabetLetters = {"N", "X", "R"};

        assertArrayEquals(demoUtils.getFirstThreeLettersOfAlphabet(), firstThreeAlphabet, "arrays should be equal");
        // assertArrayEquals(demoUtils.getFirstThreeLettersOfAlphabet(), someAlphabetLetters, "arrays should be not equal");
    }


    @Test
    @DisplayName("Iterable Equals")
    @EnabledOnJre(JRE.JAVA_18)
    void test_iterable_equals() {

        System.out.println("Number and order of elements in the collection must be the same, and iterated elements must be equal.");
        List<String> expectedStringList = List.of("string1", "string2", "string3");
        // List<String> expectedStringList2 = List.of("string3", "string2", "string1");

        assertIterableEquals(demoUtils.getListOfStrings(), expectedStringList, "list are deeply equal");
        // assertIterableEquals(demoUtils.getListOfStrings(), expectedStringList2, "list are deeply equal");

    }

    @Test
    @DisplayName("Lines match")
    @EnabledForJreRange(min = JRE.JAVA_17)
    void test_lines_match() {

        System.out.println("Number and order of elements in the collection must be the same, and iterated elements must be equal.");
        List<String> expectedStringList = List.of("string1", "string2", "string3");

        assertLinesMatch(demoUtils.getListOfStrings(), expectedStringList, "list are deeply equal");

    }

    @Test
    @DisplayName("Throw exception")
    void test_throw_exception() {

        assertThrows(Exception.class, () -> {
           demoUtils.throwExceptionIfValueIsLessThanZero(-2);
        }, "Expected to throw exception is value is less than 0");

        // assertDoesNotThrow should contain just a lambda expression
        assertDoesNotThrow(() -> {
            demoUtils.throwExceptionIfValueIsLessThanZero(22);
        }, "Expected doesn't throw exception because value is grater (or equal) than 0");

    }


    // What is the main difference between assertTimeout and assertTimeoutPreemptively?
    // https://mamedyahyayev.medium.com/what-is-the-main-difference-between-asserttimeout-and-asserttimeoutpreemptively-55eb7add837e
    // assertTimeoutPreemptively fail immediately
    // assertTimeout - this test will fail after all operations are completed

    @Test
    @DisplayName("Timeout - assertTimeoutPreemptively")
    void test_timeout_preemptively() {

        assertTimeoutPreemptively(Duration.ofSeconds(4), () -> {
            demoUtils.checkTimeout();
        }, "Should not be executed");

    }

    @Test
    @DisplayName("Timeout - assertTimeout ")
//    @EnabledIfSystemProperties()
//    @EnabledIfEnvironmentVariable()
    void test_timeout() {

        assertTimeout (Duration.ofSeconds(4), () -> {
            demoUtils.checkTimeout();
        }, "Should be executed");

    }
}
