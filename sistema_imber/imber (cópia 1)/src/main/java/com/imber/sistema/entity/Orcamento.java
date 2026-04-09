package com.imber.sistema.entity;

// Importações necessárias
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

// @Entity diz ao JPA que essa classe é uma tabela no banco de dados
@Entity
// @Table define o nome da tabela (opcional, se não colocar, o nome será "orcamento")
@Table(name = "orcamentos")
public class Orcamento {

    // ========== CAMPOS ==========
    // Cada campo vira uma coluna na tabela

    @Id  // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
    private Long id;

    // @ManyToOne indica que muitos orçamentos pertencem a um cliente
    // @JoinColumn especifica o nome da coluna que vai guardar o ID do cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // nullable false = obrigatório
    private Participante cliente;

    @Column(nullable = false, length = 200) // não pode ser nulo, tamanho máximo 200
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2) // 10 dígitos, 2 casas decimais
    private BigDecimal valor;

    private LocalDate dataOrcamento;   // data sem hora

    private LocalDate dataValidade;    // data sem hora

    @Column(length = 20)               // tamanho máximo 20
    private String status;              // ex: "PENDENTE", "APROVADO", "CANCELADO"

    @Column(length = 500)
    private String observacoes;

    // dataCadastro vai ser preenchida automaticamente com a hora atual
    private LocalDateTime dataCadastro = LocalDateTime.now();

    // ========== CONSTRUTORES ==========
    // Construtor vazio é obrigatório para o JPA
    public Orcamento() {}

    // ========== GETTERS E SETTERS ==========
    // Get = pegar o valor, Set = mudar o valor

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Participante getCliente() {
        return cliente;
    }

    public void setCliente(Participante cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(LocalDate dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}