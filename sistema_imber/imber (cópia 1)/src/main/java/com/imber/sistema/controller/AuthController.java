package com.imber.sistema.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imber.sistema.entity.UsuarioGoogle;
import com.imber.sistema.repository.ParticipanteRepository;
import com.imber.sistema.repository.UsuarioGoogleRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UsuarioGoogleRepository usuarioGoogleRepository;
    private final ParticipanteRepository participanteRepository;
    
    public AuthController(UsuarioGoogleRepository usuarioGoogleRepository, 
                          ParticipanteRepository participanteRepository) {
        this.usuarioGoogleRepository = usuarioGoogleRepository;
        this.participanteRepository = participanteRepository;
    }
    
    @GetMapping("/google/success")
    public ResponseEntity<Map<String, Object>> googleLoginSuccess(@AuthenticationPrincipal OAuth2User oauth2User) {
        String email = oauth2User.getAttribute("email");
        String nome = oauth2User.getAttribute("name");
        String googleId = oauth2User.getAttribute("sub");
        
        // Busca usuário existente pelo email
        UsuarioGoogle usuario = usuarioGoogleRepository.findByEmail(email).orElse(null);
        
        if (usuario == null) {
            // Cria novo usuário
            UsuarioGoogle novoUsuario = new UsuarioGoogle();
            novoUsuario.setEmail(email);
            novoUsuario.setNomeCompleto(nome);
            novoUsuario.setGoogleId(googleId);
            novoUsuario.setDataCadastro(LocalDateTime.now());
            novoUsuario.setAtivo(true);
            
            // Verifica se existe Participante com mesmo email e vincula
            participanteRepository.findByEmail(email).ifPresent(participante -> {
                novoUsuario.setParticipante(participante);
            });
            
            // Salva o novo usuário
            usuario = usuarioGoogleRepository.save(novoUsuario);
        }
        
        // Prepara resposta de sucesso
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Login com Google realizado com sucesso");
        response.put("email", email);
        response.put("nome", nome);
        response.put("userId", usuario.getId());
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getAuthStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("googleConnected", true);
        status.put("googleAuthUrl", "/oauth2/authorization/google");
        status.put("loginUrl", "/oauth2/authorization/google");
        status.put("status", "available");
        
        return ResponseEntity.ok(status);
    }
}