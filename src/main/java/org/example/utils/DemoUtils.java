package org.example.utils;

import lombok.Getter;

import java.util.List;

public class DemoUtils {

    @Getter
    private String testString = "some string";
    @Getter
    private String testStringDuplicate = testString;
    @Getter
    private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    @Getter
    private List<String> listOfStrings = List.of("string1", "string2", "string3");

    public int add(int a, int b) {
        return a + b;
    }

    public Object checkObjectIsNull(Object obj) {
        if (obj != null) {
            return obj;
        }

        return null;
    }

    public Boolean isGreater(int n1, int n2) {
        if (n1 > n2) {
            return true;
        }
        return false;
    }


    public String throwExceptionIfValueIsLessThanZero(int value) throws Exception {
        if (value < 0) {
            throw new Exception("Value is less than 0");
        }

        return "Value is grater or equal to 0";
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println("I'm going to sleep");
        Thread.sleep(2000);
        System.out.println("Wake up");
    }

}
