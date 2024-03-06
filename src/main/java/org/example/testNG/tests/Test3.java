package org.example.testNG.tests;

import org.testng.annotations.Test;

/**
 * Тест test_N_2 будет выполнять только
 * после выполнения 1 теста т.е. test_N_1
 */
public class Test3 {
    @Test
    public void testN_1() {
        System.out.println("test_N_1");
    }
    @Test(dependsOnMethods = {"testN_1"}, alwaysRun = true)
    public void testN_2() {
        System.out.println("test_N_2");
    }
}
