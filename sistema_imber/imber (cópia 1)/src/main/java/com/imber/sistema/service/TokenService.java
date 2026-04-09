package com.imber.sistema.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {
    
    // Armazenamento em memória para tokens (em produção, use Redis ou banco de dados)
    private final ConcurrentHashMap<String, TokenInfo> tokens = new ConcurrentHashMap<>();
    
    // Tempo de expiração do token em milissegundos (24 horas por padrão)
    private static final long DEFAULT_EXPIRATION_MS = 24 * 60 * 60 * 1000;
    
    /**
     * Gera um novo token para um usuário
     * @param userId ID do usuário
     * @param email Email do usuário
     * @return Token gerado
     */
    public String gerarToken(Long userId, String email) {
        String token = UUID.randomUUID().toString().replace("-", "");
        
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserId(userId);
        tokenInfo.setEmail(email);
        tokenInfo.setCreatedAt(LocalDateTime.now());
        tokenInfo.setExpiresAt(LocalDateTime.now().plusNanos(DEFAULT_EXPIRATION_MS * 1_000_000));
        tokenInfo.setValid(true);
        
        tokens.put(token, tokenInfo);
        
        // Limpa tokens expirados periodicamente
        limparTokensExpirados();
        
        return token;
    }
    
    /**
     * Valida se um token é válido
     * @param token Token a ser validado
     * @return true se válido, false caso contrário
     */
    public boolean validarToken(String token) {
        TokenInfo tokenInfo = tokens.get(token);
        
        if (tokenInfo == null || !tokenInfo.isValid()) {
            return false;
        }
        
        // Verifica se o token expirou
        if (tokenInfo.getExpiresAt().isBefore(LocalDateTime.now())) {
            invalidarToken(token);
            return false;
        }
        
        return true;
    }
    
    /**
     * Obtém informações do token
     * @param token Token a ser consultado
     * @return TokenInfo com as informações do token
     */
    public TokenInfo obterInformacoesToken(String token) {
        return tokens.get(token);
    }
    
    /**
     * Invalida/remove um token
     * @param token Token a ser invalidado
     */
    public void invalidarToken(String token) {
        TokenInfo tokenInfo = tokens.get(token);
        if (tokenInfo != null) {
            tokenInfo.setValid(false);
        }
        tokens.remove(token);
    }
    
    /**
     * Renova um token existente
     * @param oldToken Token antigo
     * @return Novo token gerado
     */
    public String renovarToken(String oldToken) {
        TokenInfo tokenInfo = tokens.get(oldToken);
        
        if (tokenInfo == null || !validarToken(oldToken)) {
            throw new RuntimeException("Token inválido ou expirado para renovação");
        }
        
        // Invalida o token antigo
        invalidarToken(oldToken);
        
        // Gera um novo token
        return gerarToken(tokenInfo.getUserId(), tokenInfo.getEmail());
    }
    
    /**
     * Obtém o userId associado a um token
     * @param token Token a ser consultado
     * @return ID do usuário ou null se inválido
     */
    public Long getUserIdFromToken(String token) {
        if (!validarToken(token)) {
            return null;
        }
        TokenInfo tokenInfo = tokens.get(token);
        return tokenInfo != null ? tokenInfo.getUserId() : null;
    }
    
    /**
     * Obtém o email associado a um token
     * @param token Token a ser consultado
     * @return Email do usuário ou null se inválido
     */
    public String getEmailFromToken(String token) {
        if (!validarToken(token)) {
            return null;
        }
        TokenInfo tokenInfo = tokens.get(token);
        return tokenInfo != null ? tokenInfo.getEmail() : null;
    }
    
    /**
     * Limpa tokens expirados da memória
     */
    private void limparTokensExpirados() {
        tokens.entrySet().removeIf(entry -> 
            entry.getValue().getExpiresAt().isBefore(LocalDateTime.now())
        );
    }
    
    /**
     * Gera token para integração com APIs externas
     * @param serviceName Nome do serviço
     * @param apiKey Chave da API
     * @return Token de serviço
     */
    public String gerarTokenServico(String serviceName, String apiKey) {
        String token = "SVC_" + UUID.randomUUID().toString().replace("-", "");
        
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setServiceName(serviceName);
        tokenInfo.setApiKey(apiKey);
        tokenInfo.setCreatedAt(LocalDateTime.now());
        tokenInfo.setExpiresAt(LocalDateTime.now().plusDays(30)); // 30 dias para tokens de serviço
        tokenInfo.setValid(true);
        tokenInfo.setServiceToken(true);
        
        tokens.put(token, tokenInfo);
        
        return token;
    }
    
    /**
     * Valida token de serviço
     * @param token Token do serviço
     * @param expectedService Nome do serviço esperado
     * @return true se válido
     */
    public boolean validarTokenServico(String token, String expectedService) {
        TokenInfo tokenInfo = tokens.get(token);
        
        if (tokenInfo == null || !tokenInfo.isServiceToken() || !tokenInfo.isValid()) {
            return false;
        }
        
        if (!tokenInfo.getServiceName().equals(expectedService)) {
            return false;
        }
        
        if (tokenInfo.getExpiresAt().isBefore(LocalDateTime.now())) {
            invalidarToken(token);
            return false;
        }
        
        return true;
    }
    
    /**
     * Classe interna para armazenar informações do token
     */
    public static class TokenInfo {
        private Long userId;
        private String email;
        private String serviceName;
        private String apiKey;
        private LocalDateTime createdAt;
        private LocalDateTime expiresAt;
        private boolean isValid;
        private boolean isServiceToken = false;
        
        // Getters e Setters
        public Long getUserId() {
            return userId;
        }
        
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        
        public String getEmail() {
            return email;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
        
        public String getServiceName() {
            return serviceName;
        }
        
        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }
        
        public String getApiKey() {
            return apiKey;
        }
        
        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
        
        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
        
        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
        
        public LocalDateTime getExpiresAt() {
            return expiresAt;
        }
        
        public void setExpiresAt(LocalDateTime expiresAt) {
            this.expiresAt = expiresAt;
        }
        
        public boolean isValid() {
            return isValid;
        }
        
        public void setValid(boolean valid) {
            isValid = valid;
        }
        
        public boolean isServiceToken() {
            return isServiceToken;
        }
        
        public void setServiceToken(boolean serviceToken) {
            isServiceToken = serviceToken;
        }
    }
}