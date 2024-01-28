package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Contact test = new Contact();

        ContactService service = new ContactService();
        System.out.println("Creating Contact 1");
        service.addContact();

        // System.out.println("Creating Contact 2");
        // service.addContact();

        // System.out.println("Creating Contact 3");
        // service.addContact();

        service.displayAllContacts();
        System.out.println("------------------------------------------");
        service.updateFirstName("1");
        service.displayAllContacts();
        // String contactId = "";

        // Contact abeContact = new Contact();
        // Contact taciaContact = new Contact();

        // HashMap<String, Contact> asa = new HashMap<String, Contact>();
        // abeContact.creatingContact();
        // asa.put(abeContact.getContactID(), abeContact);

        // // taciaContact.creatingContact();
        // // asa.put(abeContact.getContactID(), taciaContact);

        // Contact old = asa.get(abeContact.getContactID());
        // System.out.println("Before Update " + old);

        // old.setFirstName("Nope???");
        // asa.put(abeContact.getContactID(), old);

        // Contact new2 = asa.get(abeContact.getContactID());
        // System.out.println("After Update " + new2);

        // asa.put("123", abeContact);
        // asa.put("565", taciaContact);

        // contacts.creatingContact();
        // System.err.println(contacts);
        // contacts.readContactID();
        // String firstName = contacts.getFirstName();
        // String lastName = contacts.getLastName();
        // String phoneNumber = contacts.getPhoneNumber();
        // String address = contacts.getAddress();

        // contacts.readContactID(contactId);
        // contacts.addContact(firstName, lastName, phoneNumber, address);

    }
}