package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = "status=B")
class B_WithPropertyTest {

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
        assertEquals("B", configuredStatus);

        Thread.sleep(1000);
        statusRepository.findAll().forEach(status -> assertEquals("B", status.getStatus()));
    }

    @Test
    void test2() throws Exception {
        assertEquals("B", configuredStatus);

        Thread.sleep(1000);
        statusRepository.findAll().forEach(status -> assertEquals("B", status.getStatus()));
    }

    @Test
    void test3() throws Exception {
        assertEquals("B", configuredStatus);

        Thread.sleep(1000);
        statusRepository.findAll().forEach(status -> assertEquals("B", status.getStatus()));
    }
}
