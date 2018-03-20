package ru.sbt.jschool.session1;


public class Problem4 {
    public static void main(String[] args) {

        int count = -1;

        if (args.length>0 && args[0].startsWith("JSCHOOl1_COUNT=")){

            count = Integer.parseInt(args[0].replaceAll("\\D+",""));
        }


        try {
            if (System.getenv("JSCHOOl1_COUNT") != null) {
                count = Integer.parseInt(System.getenv("JSCHOOl1_COUNT"));
            }
        } catch (NullPointerException e ){

        }


        try {
            if (System.getProperty("JSCHOOl1_COUNT") != null) {
                count = Integer.parseInt(System.getProperty("JSCHOOl1_COUNT"));
            }
        }catch (NullPointerException e ){

        }

        if (count>=0) {

            while (count != 0) {
                System.out.println("Hello, word");
                count--;
            }
        }
        else {
            System.out.println("pass the arguments JSCHOOl1_COUNT=XXX, where XXX is count repeat");
        }




    }
}
