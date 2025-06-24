package ru.sbt.jschool.session1;

import java.util.Properties;

public class Problem2 {
    public static void solve() {
        System.out.println("=== Задача 2: Системные свойства (System Properties) ===");
        Properties sysProps = System.getProperties();
        for (String key : sysProps.stringPropertyNames()) {
            System.out.println(key + " = " + sysProps.getProperty(key));
        }
        System.out.println();
    }
}
