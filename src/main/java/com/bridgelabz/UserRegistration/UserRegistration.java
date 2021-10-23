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
    String lastName;
    String emailID;
    String mobileNumber;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public boolean validateName(String firstName) {
        String regexName = "^[A-Z]{1}[a-z]{2,}$";
        Pattern pattern = Pattern.compile(regexName);

        if (firstName.isEmpty())
            return false;
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }

    public boolean validateEmailID(String emailID) {
        String regex = "^([a-zA-z0-9-_+.]+)@([a-z0-9-]+)\\.([a-z,]{2,4})((\\.[a-z]{2,4})?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailID);
        return matcher.matches();
    }
    public boolean validateMobileNumber(String mobileNumber) {
        String regex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
    public boolean validatePassword(String password) {
        String regex = ("^(?=.*[a-z])(?=.*[A-Z]).{8,}$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void validateUserDetails() {
        Scanner scanner = new Scanner(System.in);
        UserRegistrationDetails userRegistrationDetails = new UserRegistrationDetails();
        UserRegistrationImpl userRegistration = new UserRegistrationImpl();

        System.out.print("Enter your first name: ");
        userRegistrationDetails.setFirstName(scanner.next());

        boolean flag = userRegistration.validateName(userRegistrationDetails.getFirstName());
        if (flag)
            System.out.print("");
        else
            System.out.println("Invalid input");

        System.out.print("Enter your last name: ");
        userRegistrationDetails.setLastName(scanner.next());

        boolean flagL = userRegistration.validateName(userRegistrationDetails.getLastName());
        if (flagL)
            System.out.print("");
        else
            System.out.println("Invalid input");

        System.out.print("Enter your Email ID: ");
        userRegistrationDetails.setEmailID(scanner.next());

        boolean flagMail = userRegistration.validateEmailID(userRegistrationDetails.getEmailID());
        if (flagMail)
            System.out.print("");
        else
            System.out.println("Invalid E-mail input");

        System.out.print("Enter your mobile number: 91 ");
        userRegistrationDetails.setMobileNumber(scanner.next());

        boolean flagMobileNumber = userRegistration.validateMobileNumber(userRegistrationDetails.getMobileNumber());
        if (flagMobileNumber)
            System.out.print("");
        else
            System.out.println("Invalid mobile number");

        System.out.print("Enter your password: ");
        userRegistrationDetails.setPassword(scanner.next());

        boolean flagPassword = userRegistration.validatePassword(userRegistrationDetails.getPassword());
        if (flagPassword)
            System.out.println("Password meets condition");
        else
            System.out.println("Password don't meet condition");
    }
}