package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    @DisplayName("Testing create contact method")
    void creatingContact() {



    }

    @Test
    void isValid() {
        Contact contact = new Contact();
        assertAll("contact",
                () -> assertTrue(contact.isValid("Tacia",10)),
                () -> assertFalse(contact.isValid("qqqqqqqqqq ",10)),
                () -> assertFalse(contact.isValid(" ",10))
        );
    }
}