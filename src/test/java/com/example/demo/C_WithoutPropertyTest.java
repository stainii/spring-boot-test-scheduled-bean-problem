package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class C_WithoutPropertyTest {

    @Autowired
    private StatusRepository statusRepository;

    @Value("${status}")
    private String configuredStatus;

    @BeforeEach
    void init() {
        this.statusRepository.deleteAll();
    }

    @Test
    void test1() throws Exception {
        assertEquals("A", configuredStatus);

        Thread.sleep(1000);
        statusRepository.findAll().forEach(status -> assertEquals("A", status.getStatus()));
    }

    @Test
    void test2() throws Exception {
        assertEquals("A", configuredStatus);

        Thread.sleep(1000);
        statusRepository.findAll().forEach(status -> assertEquals("A", status.getStatus()));

    }

    @Test
    void test3() throws Exception {
        assertEquals("A", configuredStatus);

        Thread.sleep(1000);
        statusRepository.findAll().forEach(status -> assertEquals("A", status.getStatus()));
    }
}
