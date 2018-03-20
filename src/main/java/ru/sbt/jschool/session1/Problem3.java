package ru.sbt.jschool.session1;

import java.util.Map;

import java.util.HashMap;
import java.util.Iterator;

public class Problem3 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map =  System.getenv();


        for ( Map.Entry m: map.entrySet()) {
            System.out.println("" + m.getKey() + ":" + m.getValue());
        }

    }
}
