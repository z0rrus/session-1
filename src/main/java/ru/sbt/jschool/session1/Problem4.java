package ru.sbt.jschool.session1;

import java.io.*;
import java.util.Properties;

public class Problem4 {
    public static void solve(String[] args) {
        System.out.println("=== Задача 4: Hello, World! N раз ===");
        Integer count = getHelloWorldCount(args);
        if (count == null) {
            System.out.println("Не указано количество повторений. Возможные способы:");
            System.out.println(" - Аргумент командной строки: JSCHOOl1_COUNT=XXX");
            System.out.println(" - Системное свойство: -DJSCHOOl1_COUNT=XXX");
            System.out.println(" - Переменная окружения: JSCHOOl1_COUNT=XXX");
            System.out.println(" - Переменная окружения JSCHOOL1_PROPERTIES_FILE=XXX (файл с настройками)");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("Hello, World!");
            }
        }
        System.out.println();
    }

    private static Integer getHelloWorldCount(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("JSCHOOl1_COUNT=")) {
                try {
                    return Integer.parseInt(arg.substring("JSCHOOl1_COUNT=".length()));
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: неверный формат числа в аргументе: " + arg);
                }
            }
        }
        String sysProp = System.getProperty("JSCHOOl1_COUNT");
        if (sysProp != null) {
            try {
                return Integer.parseInt(sysProp);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: неверный формат числа в системном свойстве: " + sysProp);
            }
        }
        String envVar = System.getenv("JSCHOOl1_COUNT");
        if (envVar != null) {
            try {
                return Integer.parseInt(envVar);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: неверный формат числа в переменной окружения: " + envVar);
            }
        }
        String propFile = System.getenv("JSCHOOL1_PROPERTIES_FILE");
        if (propFile != null) {
            File file = new File(propFile);
            if (file.exists() && file.isFile()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    Properties props = new Properties();
                    props.load(fis);
                    String value = props.getProperty("JSCHOOl1_COUNT");
                    if (value != null) {
                        try {
                            return Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            System.err.println("Ошибка: неверный формат числа в файле свойств: " + value);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка чтения файла свойств: " + propFile);
                }
            }
        }
        return null;
    }
}
