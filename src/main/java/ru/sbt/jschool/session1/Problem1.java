package ru.sbt.jschool.session1;

public class Problem1 {
    public static void solve(String[] args) {
        System.out.println("=== Задача 1: Аргументы командной строки ===");
        if (args.length == 0) {
            System.out.println("Нет переданных аргументов.");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
            }
        }
        System.out.println();
    }
}
