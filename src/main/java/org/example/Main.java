package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        ContactService service = new ContactService();
        Contact contact = new Contact();
        String contactId;
        String firstName;
        String lastName;
        String phoneNumber;
        String address;
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("------------------------------------------  ");
            System.out.println("Add");
            System.out.println("Delete");
            System.out.println("Update");
            System.out.println("Exit");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("Add")){
                System.out.println("Contact Id");
                contactId = sc.nextLine();
                contact.setContactID(contactId);
                System.out.println("First Name");
                firstName = sc.nextLine();
                contact.setFirstName(firstName);
                System.out.println("Last Name");
                lastName = sc.nextLine();
                contact.setLastName(lastName);
                System.out.println("Phone Number");
                phoneNumber = sc.nextLine();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("Address");
                address = sc.nextLine();
                contact.setAddress(address);



            }
        }



    }
}