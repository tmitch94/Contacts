package org.example;

import org.apache.commons.collections4.MultiValuedMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    ContactService contactService;
    HashMap<String, String> Contacts = new HashMap<String, String>();
    InputStream originalSystemIn;

    Contact contact;

    @BeforeEach
    public void setUp() {
        // Save the original System.in before modifying it
        contact = new Contact();
        contactService = new ContactService();
        originalSystemIn = System.in;
    }

    @Test
    public void delete() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HashMap<String, Contact> Contacts = new HashMap<>();
        Method setIdMethod = contact.getClass().getDeclaredMethod("setContactID", String.class);
        setIdMethod.setAccessible(true);
        setIdMethod.invoke(contact,"123");
        contact.setFirstName("Tacia");
        contact.setLastName("Mitchell");
        contact.setPhoneNumber("7244078643");
        contact.setAddress("Pittsburgh, Pennsylvania");
        Contacts.put(contact.getContactID(),contact);

        assertTrue(Contacts.containsKey("123"));

        setIdMethod.setAccessible(true);
        Contact addNewContact = new Contact();
        setIdMethod.invoke(addNewContact,"456");
        addNewContact.setFirstName("Tacia");
        addNewContact.setLastName("Mitchell");
        addNewContact.setPhoneNumber("7244078643");
        addNewContact.setAddress("Pittsburgh, Pennsylvania");

        Contacts.put(addNewContact.getContactID(),addNewContact);

        assertTrue(Contacts.containsKey("456"));

        contactService.deleteContact("456");
        assertFalse(Contacts.containsKey("456"));


    }


    @Test
    void updateFirstName() {
        // Arrange
        String contactId = "123";
        String originalFirstName = "";

        Contact contact = new Contact(contactId, originalFirstName, "7244078643", "Pittsburgh");
        contactService.addContact();

        String newFirstName = "Jane";
        String input = newFirstName + "\n";
        simulateSystemInput(input);

        // Act
        contactService.updateFirstName(contactId);

        // Assert
        assertEquals(newFirstName, contact.getFirstName(), "First name should be updated");
    }

    @Test
    void updateLastName() {
        // Arrange
        String contactId = "123";
        String originalLastName = "";

        Contact contact = new Contact(contactId, originalLastName, "7244078643", "Pittsburgh");
        contactService.addContact();

        String newLastName = "Mitchell";
        String input = newLastName + "\n";
        simulateSystemInput(input);

        // Act
        contactService.updateLastName(contactId);

        // Assert
        assertEquals(newLastName, contact.getLastName(), "Last name should be updated");
    }

    @Test
    void updatePhoneNumber() {
        // Arrange
        String contactId = "123";
        String originalPhonenumber = "";

        Contact contact = new Contact(contactId, originalPhonenumber, "7244078643", "Pittsburgh");
        contactService.addContact();

        String newPhoneNumber = "123456789";
        String input = newPhoneNumber + "\n";
        simulateSystemInput(input);

        // Act
        contactService.updatePhoneNumber(contactId);

        // Assert
        assertEquals(newPhoneNumber, contact.getPhoneNumber(), "Phone Number should be updated");
    }

    @Test
    void updateAddress() {
        // Arrange
        String contactId = "123";
        String originalAddress = "";

        Contact contact = new Contact(contactId, originalAddress, "7244078643", "Pittsburgh");
        contactService.addContact();

        String newAddress = "Queens";
        String input = newAddress + "\n";
        simulateSystemInput(input);

        // Act
        contactService.updateAddress(contactId);

        // Assert
        assertEquals(newAddress, contact.getAddress(), "Address should be updated");
    }

    @Test
    void addContact() {
        // Arrange
        Contact contact = new Contact();
        String contactId = "123";
        String simulatedInput = "John Doe\njohn@example.com\n1234567890\n";

        // Act
        simulateSystemInput(simulatedInput);
        contactService.addContact();

        // Assert
        assertNotNull(contact.getContactID(), "Contact should be added");
    }

    private String simulateSystemInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        return input;
    }
}