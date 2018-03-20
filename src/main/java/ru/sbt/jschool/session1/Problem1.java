package ru.sbt.jschool.session1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 */
public class Problem1 {
    /*public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }*/

    /*public static void main(String[] args) {
        Properties props = System.getProperties();
        for (Object prop : props.keySet()) {
            System.out.format("%s=%s%n",
                    prop,
                    props.get(prop));
        }
    }*/


    /*public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
    }*/

    public static void main(String[] args) {
        String helloStr = "Hello World!";
        String keyName = "JSCHOOl1_COUNT";
        String keyFile = "JSCHOOL1_PROPERTIES_FILE";
        for (String arg : args) {
            String[] vs = arg.split("=");
            if (vs[0].equals(keyName)) {
                int n = Integer.parseInt(vs[1]);
                for (int i = 0; i < n; i++) {
                    System.out.println(helloStr);
                }
                return;
            }
        }
        Properties props = System.getProperties();
        for (Object prop : props.keySet()) {
            if (prop.equals(keyName)) {
                int n = Integer.parseInt(props.get(keyName).toString());
                for (int i = 0; i < n; i++) {
                    System.out.println(helloStr);
                }
                return;
            }

        }

        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            if (envName.equals(keyName)) {
                int n = Integer.parseInt(env.get(keyName));
                for (int i = 0; i < n; i++) {
                    System.out.println(helloStr);
                }
                return;
            }

            if (envName.equals(keyFile)) {
                try (BufferedReader br = new BufferedReader(new FileReader(env.get(keyFile)))) {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    int n = Integer.parseInt(line);
                    for (int i = 0; i < n; i++) {
                        System.out.println(helloStr);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;
            }
        }

        System.out.println("Invalid input");







    }
}
