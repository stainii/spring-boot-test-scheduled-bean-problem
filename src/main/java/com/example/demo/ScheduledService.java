package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ScheduledService {

    @Autowired
    private StatusRepository statusRepository;

    @Value("${status}")
    private String status;

    @Scheduled(fixedDelay = 100)
    @Transactional
    public void updateStatus() {
        System.out.println("I'm " + this + " and I'm adding status " + status);
        statusRepository.save(new Status(status));
    }
}
