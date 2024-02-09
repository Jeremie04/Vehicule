package com.vehicule.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.Categorie;
import com.vehicule.gestion.modele.Interet;
import com.vehicule.gestion.service.InteretService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ControllerInteret {
    @Autowired
    private InteretService entiteService;
    private Gson gson = new Gson();
    private ApiResponse response;

    // @GetMapping("/interets")
    // public ResponseEntity<String> getAll() {
    // try {
    // List<Interet> interets = entiteService.findAll();
    // response = new ApiResponse("", interets);
    // return ResponseEntity.ok(gson.toJson(response));
    // } catch (Exception e) {
    // response = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(e.getMessage());
    // }
    // }

    // @GetMapping("/interet/")
    // public ResponseEntity<String> save(@RequestBody Interet interet) {
    // try {
    // response = new ApiResponse("", entiteService.save(interet));
    // return ResponseEntity.ok(gson.toJson(response));
    // } catch (Exception e) {
    // response = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(gson.toJson(response));
    // }
    // }

    // @Transactional(rollbackOn = Exception.class)
    // @PostMapping("/interet/{id}")
    // public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
    // try {
    // entiteService.deleteById(id);
    // return ResponseEntity.ok("Interet id = " + id + " deleted successfully.");
    // } catch (Exception e) {
    // e.printStackTrace();
    // response = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(gson.toJson(response));
    // }
    // }

}
