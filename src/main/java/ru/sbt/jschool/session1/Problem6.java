package ru.sbt.jschool.session1;

public class Problem6 {
    public static String sumOfBinary(String b1, String b2) {
        StringBuilder sb = new StringBuilder();
        int i = b1.length() - 1, j = b2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += b1.charAt(i--) - '0';
            if (j >= 0) sum += b2.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}
