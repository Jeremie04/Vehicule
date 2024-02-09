package com.vehicule.gestion.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vehicule.gestion.modele.ImageAnnonce;

@Repository
public interface ImageAnnonceRepository extends JpaRepository<ImageAnnonce, String> {
    List<ImageAnnonce> findAll();

    List<ImageAnnonce> findAllByidImageAnnonce(String id);

    List<ImageAnnonce> findAllByImage(String nomImageAnnonce);
}

