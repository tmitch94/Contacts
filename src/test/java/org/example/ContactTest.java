package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ContactTest {
    @Mock
    Scanner sc;

    @Mock
    Contact contact;

    @Test
    @DisplayName("Testing create contact method")
    void creatingContact(@Mock Comparable<String> c) {



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