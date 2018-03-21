package ru.sbt.jschool.session1;

/**
 * Created by user7 on 21.03.2018.
 */
public class Problem4 {
    public static void main(String[] args) {
        if (args[0] != null && args[0].contains("JSCHOOl1_COUNT=")) {
            int start = args[0].indexOf("=") + 1;
            String buf = new char[args[0].length() - start];
            args[0].getChars(start, args[0].length(), buf, 0);
            int max = Integer.parseInt(buf);
            for (int i = 0; i < max; i++) {
                System.out.println("Hello world");
            }
        }
    }
}
