package ru.sbt.jschool.session1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Problem1.solve(args);
        Problem2.solve();
        Problem3.solve();
        Problem4.solve(args);

        System.out.println("=== Дополнительные задачи ===");
        String binaryExample = "101101";
        System.out.println("// Задача 5: binaryToDec(\"" + binaryExample + "\") = " + Problem5.binaryToDec(binaryExample));
        String b1 = "1101", b2 = "1011";
        System.out.println("// Задача 6: sumOfBinary(\"" + b1 + "\", \"" + b2 + "\") = " + Problem6.sumOfBinary(b1, b2));
        long[] arr1 = {1,2,3,4,5}, arr2 = {4,5,6,7};
        System.out.print("// Задача 7: intersection([1,2,3,4,5], [4,5,6,7]) = ");
        System.out.println(Arrays.toString(Problem7.intersection(arr1, arr2)));
    }
}
