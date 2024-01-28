package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    ContactService contactService = new ContactService();
    HashMap<String, String> Contacts = new HashMap<String, String>();

    @Test
    void deleteContact() {
        String id = "123";
        Contacts.put(id,"test");
        Contacts.remove(id);
        boolean deletionResults = contactService.deleteContact(id);
        assertTrue(deletionResults);
        assertFalse(contactService.deleteContact(id));


    }

    @Test
    void updateFirstName() {
    }

    @Test
    void updateLastName() {
    }

    @Test
    void updatePhoneNumber() {
    }

    @Test
    void updateAddress() {
    }

    @Test
    void addContact() {
    }
}