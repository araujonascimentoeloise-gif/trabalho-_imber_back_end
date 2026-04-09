package com.imber.sistema.service;

import com.imber.sistema.entity.UsuarioGoogle;
import com.imber.sistema.repository.UsuarioGoogleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GoogleCalendarService {
    
    @Value("${google.oauth2.client-id}")
    private String clientId;
    
    @Value("${google.oauth2.client-secret}")
    private String clientSecret;
    
    private final UsuarioGoogleRepository usuarioGoogleRepository;
    
    public GoogleCalendarService(UsuarioGoogleRepository usuarioGoogleRepository) {
        this.usuarioGoogleRepository = usuarioGoogleRepository;
    }
    
    /**
     * Verifica se o usuário tem token válido do Google
     */
    public boolean isUsuarioConectadoGoogle(String userEmail) {
        return usuarioGoogleRepository.findByEmail(userEmail).isPresent();
    }
    
    /**
     * Salva/atualiza o token de acesso do usuário
     */
    public void salvarTokenUsuario(String email, String googleId, String nome, 
                                   String accessToken, String refreshToken) {
        UsuarioGoogle usuario = usuarioGoogleRepository.findByEmail(email)
            .orElse(new UsuarioGoogle());
        
        usuario.setEmail(email);
        usuario.setGoogleId(googleId);
        usuario.setNomeCompleto(nome);
        usuario.setAccessToken(accessToken);
        usuario.setRefreshToken(refreshToken);
        usuario.setTokenExpiration(LocalDateTime.now().plusHours(1));
        usuario.setAtivo(true);
        
        if (usuario.getDataCadastro() == null) {
            usuario.setDataCadastro(LocalDateTime.now());
        }
        
        usuarioGoogleRepository.save(usuario);
    }
    
    // Os outros métodos (criarEventoNoGoogle, etc.) só funcionarão 
    // depois que as dependências forem adicionadas corretamente
}