package com.quicktutorialz.learntesting.DemoTest.utilities;

/**
 * Demonstrative class used in SpringBootJwtApplication#main() in order to demonstrate the use of
 * ReflectionUtils static methods to write and read a class private field from outside.
 */
public class ReflectionTestClass {

    private String myField = "Ciao";

    private String ciao(String a, String b, int c){
        return "ciao " + a + " " + b + " " + c;
    }

    private String hello(){
        return "hello";
    }
}