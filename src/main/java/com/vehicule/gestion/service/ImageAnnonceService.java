package com.vehicule.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.gestion.modele.ImageAnnonce;
import com.vehicule.gestion.repository.ImageAnnonceRepository;

import java.util.List;

@Service
public class ImageAnnonceService {
    @Autowired
    private ImageAnnonceRepository imageAnnonce;

    public List<ImageAnnonce> findAll() {
        return imageAnnonce.findAll();
    }

    public List<ImageAnnonce> findAllById(Iterable<String> id) {
        return imageAnnonce.findAllById(id);
    }

    public List<ImageAnnonce> findAllByIamge(String nom) {
        return imageAnnonce.findAllByImage(nom);
    }

    public ImageAnnonce save(ImageAnnonce c) {
        return imageAnnonce.save(c);
    };

}
