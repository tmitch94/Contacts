package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.*;

public class Contact {

    // declare private variables to hold contact information. Contact information
    // will be set by users
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // public Contact(String contactID) {
    // this.contactID = contactID;
    // }

    // method to read userInput for ID that does checks.
    // public String readContactID() {
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter a unique contact id: ");

    // contactID = sc.nextLine();
    // if (contactID.contains(" ")) {
    // System.out.println("Contact ID must not have spaces!");
    // return null;
    // } else if (contactID.isEmpty()) {
    // System.out.println("Contact ID can not be empty!");
    // return null;
    // } else if (contactID.length() >= 11) {
    // System.out.println("Contacts can only have 1 to 10 characters. You entered "
    // + contactID.length());
    // return null;
    // } else {
    // return contactID;
    // }

    // }

    private void setContactID(String id) {
        this.contactID = id;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to add contacts using a unique ID
    public Contact creatingContact(Scanner sc) {

        System.out.print("Enter your Unique ID: ");
        String id = sc.nextLine();
        while (true) {
            if (isValid(id, 10)) {
                setContactID(id);
                break;
            } else {
                System.out.print("Enter your Unique ID: ");
                id = sc.nextLine();
            }
        }
        setContactID(id);


        System.out.println("Enter your first name: ");
        String fName = sc.nextLine();
        while (!isValid(fName, 10)) {
            System.out.println("Enter your first name: ");
            fName = sc.nextLine();
        }
        setFirstName(fName);

        System.out.println("Enter your last name: ");
        String lName = sc.nextLine();
        while (!isValid(lName, 10)) {
            System.out.println("Enter your first name: ");
            lName = sc.nextLine();
        }
        setLastName(lName);

        System.out.println("Enter your phone number: ");
        String pNumber = sc.nextLine();
        while (!isValid(pNumber, 10)) {
            System.out.println("Enter your phone number. ");
            pNumber = sc.nextLine();
        }
        setPhoneNumber(pNumber);

        System.out.println("Enter your address: ");
        String userAddress = sc.nextLine();
        while (!isValid(userAddress, 30)) {
            System.out.println("Enter your address. Address must be less than 30 characters");
            userAddress = sc.nextLine();
        }
        setAddress(userAddress);

        return this;
    }

    public String toString() {
        return String.format("ID: %s %s %s  %s   %s", this.contactID, this.firstName, this.lastName, this.phoneNumber,
                this.address);
    }

    public boolean isValid(String fieldName, int allowedLength) {
        checkSpecialCharacters(fieldName);
        if (fieldName.trim().isEmpty()) {
            System.out.println("Field can't be Empty!");
            return false;
        } else if (fieldName.length() > allowedLength) {
            System.out.printf("Can only be %d characters or less\n", allowedLength);
            return false;
        } else {
            return true;
        }
    }

     private String checkSpecialCharacters(String fieldName) {
     String replacedString = "";
     for (int i = 0; i < fieldName.length(); i++) {
     char c = fieldName.charAt(i);
     if (c == '-') {
     fieldName = fieldName.replaceAll("[^\\w\\s]", replacedString);
     } else if (c == ' ') {
     fieldName = fieldName.replaceAll(" ", replacedString);
     }
     }
     return fieldName;
     }

}
