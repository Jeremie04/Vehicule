package com.vehicule.gestion.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import com.google.gson.Gson;
import com.vehicule.gestion.modele.ApiResponse;
import com.vehicule.gestion.modele.TraitementImage;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ControllerImage {

    @Autowired
    private Gson gson = new Gson();
    private ApiResponse reponse;

    // Uploading image
    // @PostMapping("/traitementimage/{file}")
    // public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile
    // file) throws Exception {
    // TraitementImage timage = new TraitementImage();
    // try {
    // String pathfichier = timage.uploadImage(file);
    // String test = timage.hebergementImage(pathfichier);
    // return ResponseEntity.ok("Uploaded " + test + " .");
    // } catch (Exception e) {
    // e.printStackTrace();
    // reponse = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(gson.toJson(reponse));
    // }
    // }

    // Inmage en base 64
    // @PostMapping("/traitementimage/{file}")
    // public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile
    // file) throws Exception {
    // TraitementImage timage = new TraitementImage();
    // try {
    // String pathfichier = timage.uploadImage(file);
    // // String test = timage.ImageToBase64(file);
    // return ResponseEntity.ok("Uploaded " + " .");
    // } catch (Exception e) {
    // e.printStackTrace();
    // reponse = new ApiResponse(e.getMessage(), null);
    // return ResponseEntity.status(500).body(gson.toJson(reponse));
    // }
    // }

    @PostMapping("/traitementimage")
    public ResponseEntity<String> uploadImage() throws Exception {
        TraitementImage timage = new TraitementImage();
        try {
            TraitementImage t = new TraitementImage();
            Path f = Path.of(TraitementImage.getUPLOAD_DIRECTORY() + "/Peugeot-405-02.jpg");
            String string = Base64.getEncoder().encodeToString(Files.readAllBytes(f));
            return ResponseEntity.ok(string);
        } catch (Exception e) {
            e.printStackTrace();
            reponse = new ApiResponse(e.getMessage(), null);
            return ResponseEntity.status(500).body(gson.toJson(reponse));
        }
    }
}
