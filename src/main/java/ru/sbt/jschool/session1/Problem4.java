package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.util.Properties;

public class Problem4 {
    private static boolean checkArg = false;

    public static void main(String[] args) {

        // System.setProperty("JSCHOOl1_COUNT", "6");
        if (args.length > 0 && args[0].startsWith("JSCHOOl1_COUNT")) {

            String[] s = args[0].split("=");
            HW(s[1]);
            return;

        }


        String s = System.getenv("JSCHOOl1_COUNT");
        if (s != null) {
            HW(s);
            if(checkArg) {
                return;
            }
        }

        s = System.getProperty("JSCHOOl1_COUNT");
        if (s != null) {
            HW(s);
            if(checkArg) {
                return;
            }
        }

        String path = System.getenv("SCHOOL1_PROPERTIES_FILE");
        if (path!=null){
            try {
                Properties prs = new Properties();
                prs.load(new FileInputStream(path));
                s = prs.getProperty("JSCHOOl1_COUNT");
                HW(s);

            } catch (Exception e){
                System.out.println("Oops");
            }
        }


        System.out.println("   Property value should be defined as one of following ways:");
        System.out.println("   Command line arguments JSCHOOL1_COUNT=XXX.");
        System.out.println("   System property JSCHOOL1_COUNT=XXX");
        System.out.println("   Environment variable JSCHOOL1_COUNT=XXX");
        System.out.println("   In property file from JSCHOOL1_PROPERTIES_FILE=XXX, where XXX is path to property file.");

    }

    private static void HW(String s) {
        try {
            int count = Integer.parseInt(s);
            for (int i = 0; i < count; i++) {
                System.out.println("Hello, World!");

            }
            checkArg = true;
        } catch (Exception e) {
            System.out.println("Oops");
        }
    }
}
