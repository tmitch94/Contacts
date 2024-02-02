package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class ContactService {
    HashMap<String, Contact> Contacts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public void deleteContact(String id) {
        if (Contacts.containsKey(id)) {
            Contacts.remove(id);
            System.out.println(id + " Has been removed");
        } else {
            System.out.println("Doesnt Exists");
        }

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
        int counter = 0;
        Contact newContact = new Contact();
        newContact = newContact.creatingContact(sc);
        Contacts.put(newContact.getContactID(), newContact);

        while (true){
            System.out.println("What would you like to do next?");
            System.out.println("------------------------------------------  ");
            System.out.println("Add");
            System.out.println("Delete");
            System.out.println("Update");
            System.out.println("Exit");
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
                            continue;
                        case 2:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updateLastName(id);
                            continue;
                        case 3:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updatePhoneNumber(id);
                            continue;
                        case 4:
                            System.out.println("Enter a key value");
                            id = sc.nextLine();
                            updateAddress(id);
                            continue;
                        default:
                            System.out.println("Enter a valid choice");
                            continue;
                    }
            }

            else if (userInput.equalsIgnoreCase("Add")){
                //System.out.println("Adding person number " + counter);
                Contact addNewContact = new Contact();
                addNewContact = addNewContact.creatingContact(sc);
                Contacts.put(addNewContact.getContactID(),addNewContact);
                //Contacts.clear();
               // counter++;
            } else if (userInput.equalsIgnoreCase("Delete")) {
                System.out.println("Enter contact ID you wish to delete");
                String id = sc.nextLine();
                deleteContact(id);
            } else if (userInput.equalsIgnoreCase("Exit")) {
                System.out.println("Displaying contacts");
                System.out.println("------------------------------------------");
                displayAllContacts();
                System.out.println("Closing contact program");
                sc.close();
                System.exit(0);
            } else {
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
