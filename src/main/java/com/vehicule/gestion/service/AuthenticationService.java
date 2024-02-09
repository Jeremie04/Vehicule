package com.vehicule.gestion.service;

import com.vehicule.gestion.auth.AuthenticationRequest;
import com.vehicule.gestion.auth.AuthenticationResponse;
import com.vehicule.gestion.auth.RegisterRequest;
import com.vehicule.gestion.modele.Utilisateur;
import com.vehicule.gestion.repository.UtilisateurRepository;
import com.vehicule.gestion.tools.JwtUtil;
import com.vehicule.gestion.tools.Role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  private UtilisateurRepository utilisateurRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UtilisateurService service;

  public AuthenticationResponse register(RegisterRequest request) throws Exception {
    // Utili
    var user = new Utilisateur();
    user.setMail(request.getLogin());
    Optional<Utilisateur> categorie = service.findByMail(request.getLogin());
    if (user.isNomDuplacated(categorie) == true) {
      user.setMotDePasse(passwordEncoder.encode(request.getMotDePasse()));
      String role = request.getRole();
      if (role.compareToIgnoreCase("admin") == 0) {
        user.setRole(Role.ROLE_ADMIN);
      } else {
        user.setRole(Role.ROLE_USER);
      }
      user.setAdresse(request.getAdresse());
      user.setNom(request.getNom());
      user.setPrenom(request.getPrenom());
      user.setSexe(request.getSexe());
      user.setDateNaissance(request.getDateNaissance());
      utilisateurRepository.save(user);
      var jwtToken = jwtUtil.generateToken(user);
      return new AuthenticationResponse(jwtToken);
    }
    else{
    throw new Exception("Mail deja associe à un autre compte");
    }
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    System.out.println(utilisateurRepository.findByMail(request.getLogin()));
    System.out.println(request.getLogin());
    System.out.println(request.getMotDePasse());
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getLogin(),
            request.getMotDePasse()));
    var user = utilisateurRepository
        .findByMail(request.getLogin())
        .orElseThrow();
    var token = jwtUtil.generateToken(user);

    AuthenticationResponse response = new AuthenticationResponse(token);
    return response;
  }
}
