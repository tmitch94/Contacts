package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class ContactService {
    HashMap<String, Contact> Contacts = new HashMap<String, Contact>();
    static Scanner sc = new Scanner(System.in);

    public void deleteContact(String id) {
        // Contact x = Contacts.get(id);
        if (Contacts.containsKey(id)) {
            Contacts.remove(id);
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

    public void updateAddress(String id) {
        Contact infoToUpdate = Contacts.get(id);

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
        Contact newContact = new Contact();
        newContact = newContact.creatingContact(sc);
        Contacts.put(newContact.getContactID(), newContact);
    }

    public void displayAllContacts() {
        for (Contact contact : Contacts.values()) {
            System.out.println(contact);
        }
    }

}
