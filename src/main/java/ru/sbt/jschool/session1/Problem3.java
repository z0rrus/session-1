package ru.sbt.jschool.session1;

import java.util.Map;

public class Problem3 {
    public static void solve() {
        System.out.println("=== Задача 3: Переменные окружения (Environment Variables) ===");
        Map<String, String> envVars = System.getenv();
        for (Map.Entry<String, String> entry : envVars.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
    }
}
