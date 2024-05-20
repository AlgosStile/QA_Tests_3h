package org.example.sber;

public class Sber2 {
    String global = "111";

    public int parser(String arg) {
        int value = 0;
        try {
            String global = arg;
            value = Integer.parseInt(global);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        System.out.println(global + " " + value + "");
        return value;
    }

    public static void main(String[] args) {
        Sber2 ct = new Sber2();
        System.out.println(ct.parser("333"));
    }

}


