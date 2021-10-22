package com.bridgelabz.UserRegistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static void main(String[] args) {
        UserRegistrationImpl userRegistration = new UserRegistrationImpl();
        userRegistration.validateUserDetails();
    }
}

class UserRegistrationDetails {
    String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

class UserRegistrationImpl {
    /**
     * Validation of the user entered first name using regex
     * Name should begin with a capital letter
     * The name should at-least contain 3 letters
     */

    public boolean validateFirstName(String firstName) {
        String regexName = "^[A-Z]{1}[a-z]{2,}$";
        Pattern pattern = Pattern.compile(regexName);

        if (firstName.isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    public void validateUserDetails() {
        Scanner scanner = new Scanner(System.in);
        UserRegistrationDetails userRegistrationDetails = new UserRegistrationDetails();
        UserRegistrationImpl userRegistration = new UserRegistrationImpl();

        System.out.println("Enter your first name ");
        userRegistrationDetails.setFirstName(scanner.next());

        boolean flag = userRegistration.validateFirstName(userRegistrationDetails.getFirstName());
        if (flag) {
            System.out.println("Valid input");
        } else {
            System.out.println("Invalid input");
        }
    }
}