package org.example.sber;

public class Sber4 {

    public static void main(String... args) {
        ExamleClass2 example = new ExamleClass2();
        example.getVersion();
    }
}

class ExamleClass1 {
    private String ver = "0";

    protected void getVersion() {
        System.out.println(ver);
    }
}

class ExamleClass2 extends ExamleClass1 {
    private String ver = "1";

    @Override
    public void getVersion() {
        System.out.println(ver);
    }

}

