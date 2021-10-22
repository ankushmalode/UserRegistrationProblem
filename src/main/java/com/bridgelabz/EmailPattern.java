package com.bridgelabz;

import java.util.*;

public class EmailPattern {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        //String pattern to be detected
        String match = "^[A-Za-z0-9+_.-]+@(.+)$";

        //Checking for matches
        while(true) {

            // String to be scanned to find the pattern.
            System.out.print("Please enter your Email: ");
            String line = sc.nextLine();

            //Condition check
            boolean check=line.matches(match);
            if(check) {
                System.out.print("You have entered correct Email address.");
                break;
            }else{
                System.out.print("Incorrect format, try again.");
            }
        }
    }
}
