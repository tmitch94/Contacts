package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        ContactService service = new ContactService();
        System.out.println("Creating Contact ");
        service.addContact();

        System.out.println("------------------------------------------");
        service.displayAllContacts();

    }
}