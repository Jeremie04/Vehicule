package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicule.gestion.modele.Test;
import com.vehicule.gestion.service.TestService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService test;

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Test> testSelect() {
        return test.findOrderBy();
    }

}
