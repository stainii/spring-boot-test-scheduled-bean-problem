package com.example.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    public Status() {

    }

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
