package com.bank.stb.modelo;

import com.bank.stb.enums.StatusTransacao;
import com.bank.stb.enums.TipoTransacao;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao", indexes = {@Index(name = "", columnList = "")})
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transacaoId;


    @Column(nullable = false, name = "")
    private BigDecimal valorTransferido;

    @Column(nullable = false, name = "")
    private Data criadoEm;

    @Column(nullable = false, name = "")
    private LocalDateTime atualizadaEm;

    @Column(nullable = false, name = "")
    private String contaId;

    @Column(name = "")
    private String recursoId;

    @Column(name = "")
    private BigDecimal backupValorTransferido;

    @Column(nullable = false, name = "numero_tentativas_para_conclusao_da_transacao")
    private Integer numeroTentativas;

    @Column(nullable = false, name = "transacao_foi_revertida_ou_nao")
    private boolean transacoesRevertidas;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTransacao status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_de_transacao")
    private TipoTransacao tipoTransacao;

    @PrePersist
    public static Transacao criarTransacao(Transacao transacao) {
        if (transacao.valorTransferido.compareTo(BigDecimal.ONE) <= 0) {
            throw new IllegalStateException("O valor da transação deve ser maior que zero.");
        }
        return new Transacao();
    }

    public void transacao() {
        if (this.status != StatusTransacao.PENDENTE) {
            throw new IllegalStateException("A transação deve estar no estado PENDENTE para ser confirmada.");
        }
        this.status = StatusTransacao.PROCESSADO;
        this.atualizadaEm = LocalDateTime.now();
    }

    public void reverter(){
        if (this.status == StatusTransacao.PROCESSADO){
            throw new IllegalStateException("");
        }
        this.status = StatusTransacao.REVERTIDO;
        this.transacoesRevertidas = true;
        this.atualizadaEm = LocalDateTime.now();
    }

    public void contaNumeroTentativasTransacoes(){
        this.numeroTentativas++;
    }

    public boolean transacaoConclida(){
        return this.status == StatusTransacao.PROCESSADO;
    }

    public boolean transacaoFalhou(){
        return this.status == StatusTransacao.REJEITADA;
    }

    public Long getId() {
        return id;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public BigDecimal getValorTransferido() {
        return valorTransferido;
    }

    public Data getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadaEm() {
        return atualizadaEm;
    }

    public String getContaId() {
        return contaId;
    }

    public String getRecursoId() {
        return recursoId;
    }

    public BigDecimal getBackupValorTransferido() {
        return backupValorTransferido;
    }

    public Integer getNumeroTentativas() {
        return numeroTentativas;
    }

    public boolean isTransacoesRevertidas() {
        return transacoesRevertidas;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }
}
