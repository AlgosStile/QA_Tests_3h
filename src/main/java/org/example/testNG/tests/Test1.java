package org.example.testNG.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @DataProvider(name = "db")
    public static Object[][] dbData() {
        return new Object[][] {
                {"SQL", 1},
                {"SQL", 2}
        };
    }

    @Parameters({"db"})
//    @Test(groups = {"smokeTest", "regress"})
    @Test(dataProvider = "db" )
    public void test1(String e1, int e2) {
        System.out.println("Test 1" + " " + e1 + " " + e2);
    }
    @Test(groups = {"regress"})
    public void test11() {
        System.out.println("Test 11");
    }
    @Test(groups = {"regress"})
    public void test111() {
        System.out.println("Test 111");
    }

    @Test(retryAnalyzer = Retry.class)
    public void test5() {
        System.out.println("Test Retry ---> true!");
        Assert.fail();
    }

}
