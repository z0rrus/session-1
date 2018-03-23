package ru.sbt.jschool.session1;


import java.util.*;

public class AdditionalProblem {

    public static void main(String[] args){
        AdditionalProblem c = new AdditionalProblem();
        System.out.println(c.binaryToDec("101111010"));
        System.out.println(c.sumOfBinary("101111010", "0001"));
        long[] b = {45,45,23,57,5,576};
        long[] a = {456,7,576,435,345,3,452,43,5};

        for (long i: c.intersection(a,b))
             System.out.print(i + "  : ");
    }
    public long binaryToDec(String binary){
        return  Long.parseLong(binary, 2);
    }

    public long sumOfBinary(String b1, String b2){

        Long n1 =Long.parseLong(b1);
        Long n2 =Long.parseLong(b2);
        return n1+n2;

    }
    public long[] intersection(long[] arr1, long[] arr2) {

        List<Long> res = new ArrayList<>();
        Arrays.sort(arr1);
        for (long i : arr2) {
            if (Arrays.binarySearch(arr1, i) > -1) {
                if (!res.contains(i))
                    res.add(i);
            }
        }

        long[] result = new long[res.size()];
        for (long i : res) {
            result[res.indexOf(i)] = i;
            }

        return result;
    }






}
