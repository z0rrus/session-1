package ru.sbt.jschool.session1;

public class Problem5 {
    public static long binaryToDec(String binary) {
        long result = 0;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Строка не является бинарной: " + binary);
            }
            result = (result << 1) + (c - '0');
        }
        return result;
    }
}
