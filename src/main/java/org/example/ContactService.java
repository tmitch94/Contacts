package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class ContactService {
    HashMap<String, Contact> Contacts = new HashMap<String, Contact>();
    static Scanner sc = new Scanner(System.in);

    public boolean deleteContact(String id) {

        return false;
    }

    public void updateFirstName(String id) {
        Contact infoToUpdate = Contacts.get(id);

        System.out.println("Enter your New First Name: ");
        String newFirst = sc.nextLine();
        while (true) {
            if (infoToUpdate.isValid(newFirst, 10)) {
                infoToUpdate.setFirstName(newFirst);
                break;
            } else {
                System.out.println("Enter your New First Name: ");
                newFirst = sc.nextLine();
            }
        }
        Contacts.put(infoToUpdate.getContactID(), infoToUpdate);
    }

    public void updateLastName(String id) {
        Contact infoToUpdate = Contacts.get(id);

        System.out.println("Enter your New Last Name: ");
        String newLast = sc.nextLine();
        while (true) {
            if (infoToUpdate.isValid(newLast, 10)) {
                infoToUpdate.setLastName(newLast);
                break;
            } else {
                System.out.println("Enter your New Last Name: ");
                newLast = sc.nextLine();
            }
        }
        Contacts.put(infoToUpdate.getContactID(), infoToUpdate);

    }

    public void updatePhoneNumber(String id) {
        Contact infoToUpdate = Contacts.get(id);

        System.out.println("Enter your New Number: ");
        String newNumber = sc.nextLine();
        while (true) {
            if (infoToUpdate.isValid(newNumber, 10)) {
                infoToUpdate.setPhoneNumber(newNumber);
                break;
            } else {
                System.out.println("Enter your New Number: ");
                newNumber = sc.nextLine();
            }
        }
        Contacts.put(infoToUpdate.getContactID(), infoToUpdate);

    }

    public void updateAddress(String contactID) {
        Contact infoToUpdate = Contacts.get(contactID);

        System.out.println("Enter your New Address: ");
        String newAddress = sc.nextLine();
        while (true) {
            if (infoToUpdate.isValid(newAddress, 10)) {
                infoToUpdate.setAddress(newAddress);
                break;
            } else {
                System.out.println("Enter your New Address: ");
                newAddress = sc.nextLine();
            }
        }
        Contacts.put(infoToUpdate.getContactID(), infoToUpdate);
    }

    public void addContact() {
        // Scanner scan = new Scanner(System.in);
        int counter = 1;
        while (true){
            Contact newContact = new Contact();
            newContact = newContact.creatingContact(sc);
            Contacts.put(newContact.getContactID(), newContact);
            System.out.println("What would you like to do next?");
            System.out.println("------------------------------------------  ");
            System.out.println("Add");
            System.out.println("Delete");
            System.out.println("Update");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("update")) {
                System.out.println("Please enter the corresponding number");
                System.out.println("---------------------------------------------   ");
                System.out.println("1: First Name");
                System.out.println("2: Last Name");
                System.out.println("3: Phone Number");
                System.out.println("4: Address");
                int choice = sc.nextInt();
                sc.nextLine();
                String id = " ";
                    switch (choice) {
                        case 1:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updateFirstName(id);
                            break;
                        case 2:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updateLastName(id);
                            break;
                        case 3:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updatePhoneNumber(newContact.getPhoneNumber());
                            break;
                        case 4:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updateAddress(newContact.getAddress());
                            break;
                        default:
                            System.out.println("Enter a valid choice");
                            break;
                    }
            }

            if (userInput.equalsIgnoreCase("Add")){
                counter++;
                System.out.println("Adding person number " + counter);
            }else {
                break;
            }
        }

    }

    public void displayAllContacts() {
        for (Contact contact : Contacts.values()) {
            System.out.println(contact);
        }
    }

}
