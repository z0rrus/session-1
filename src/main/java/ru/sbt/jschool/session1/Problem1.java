package ru.sbt.jschool.session1;

import java.util.*;
import java.io.*;

/**
 * Решения обязательных и дополнительных задач Session 1
 */
public class Problem1 {
    public static void main(String[] args) {
        // === Задача 1: Вывод всех аргументов командной строки ===
        System.out.println("=== Задача 1: Аргументы командной строки ===");
        if (args.length == 0) {
            System.out.println("Нет переданных аргументов.");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
            }
        }
        System.out.println();

        // === Задача 2: Вывод всех системных свойств ===
        System.out.println("=== Задача 2: Системные свойства (System Properties) ===");
        Properties sysProps = System.getProperties();
        for (String key : sysProps.stringPropertyNames()) {
            System.out.println(key + " = " + sysProps.getProperty(key));
        }
        System.out.println();

        // === Задача 3: Вывод всех переменных окружения ===
        System.out.println("=== Задача 3: Переменные окружения (Environment Variables) ===");
        Map<String, String> envVars = System.getenv();
        for (Map.Entry<String, String> entry : envVars.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        // === Задача 4: Вывод "Hello, World!" N раз ===
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

        // === Дополнительные задачи ===
        System.out.println("=== Дополнительные задачи ===");

        // Задача 5: Перевод из двоичной системы в десятичную
        String binaryExample = "101101";
        System.out.println("// Задача 5: binaryToDec(\"" + binaryExample + "\") = " + binaryToDec(binaryExample));

        // Задача 6: Сумма двух двоичных чисел
        String b1 = "1101";
        String b2 = "1011";
        System.out.println("// Задача 6: sumOfBinary(\"" + b1 + "\", \"" + b2 + "\") = " + sumOfBinary(b1, b2));

        // Задача 7: Пересечение двух массивов long
        long[] arr1 = {1, 2, 3, 4, 5};
        long[] arr2 = {4, 5, 6, 7};
        System.out.print("// Задача 7: intersection([1,2,3,4,5], [4,5,6,7]) = ");
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }

    /**
     * Определяет, сколько раз нужно вывести "Hello, World!".
     * Приоритет:
     * 1. Аргумент командной строки JSCHOOl1_COUNT=XXX
     * 2. Системное свойство JSCHOOl1_COUNT
     * 3. Переменная окружения JSCHOOl1_COUNT
     * 4. Файл, указанный в JSCHOOL1_PROPERTIES_FILE
     * @param args Аргументы командной строки
     * @return Количество повторений или null
     */
    private static Integer getHelloWorldCount(String[] args) {
        // 1. Проверка аргументов командной строки
        for (String arg : args) {
            if (arg.startsWith("JSCHOOl1_COUNT=")) {
                try {
                    return Integer.parseInt(arg.substring("JSCHOOl1_COUNT=".length()));
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: неверный формат числа в аргументе: " + arg);
                }
            }
        }
        // 2. Проверка системных свойств
        String sysProp = System.getProperty("JSCHOOl1_COUNT");
        if (sysProp != null) {
            try {
                return Integer.parseInt(sysProp);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: неверный формат числа в системном свойстве: " + sysProp);
            }
        }
        // 3. Проверка переменных окружения
        String envVar = System.getenv("JSCHOOl1_COUNT");
        if (envVar != null) {
            try {
                return Integer.parseInt(envVar);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: неверный формат числа в переменной окружения: " + envVar);
            }
        }
        // 4. Проверка файла с настройками
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

    // === Дополнительные задачи ===

    /**
     * Переводит бинарную строку в десятичное число.
     */
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

    /**
     * Складывает два двоичных числа, представленных строками.
     * Возвращает строку-результат в двоичной системе.
     */
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

    /**
     * Возвращает элементы, которые встречаются в обоих массивах.
     */
    public static long[] intersection(long[] arr1, long[] arr2) {
        Set<Long> set1 = new HashSet<>();
        for (long l : arr1) set1.add(l);
        Set<Long> result = new LinkedHashSet<>();
        for (long l : arr2) {
            if (set1.contains(l)) result.add(l);
        }
        long[] res = new long[result.size()];
        int idx = 0;
        for (long l : result) res[idx++] = l;
        return res;
    }
}
