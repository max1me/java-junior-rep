package com.lessons.maven;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidatorsTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }
    @Test
    public void testName() {
//        assertTrue(Validators.isPositive(1));
        assertAll("Positivertue",
                () -> assertTrue(Validators.isPositive(1)),
                () -> assertTrue(Validators.isPositive(100)));
    }

}
