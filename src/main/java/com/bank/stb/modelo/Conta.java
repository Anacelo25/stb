package com.bank.stb.modelo;

import com.bank.stb.enums.StatusTransacao;
import com.bank.stb.enums.TipoTransacao;
import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "Conta", indexes = {@Index(name = "", columnList = "")})
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroConta;

    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal saldo;

    @Column(nullable = false)
    private String moeda;

    @Version
    @Column(nullable = false, name = "Version")
    private Long versao;

    @Column(nullable = false, name = "Fase_Transacao")
    private boolean faseTransacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

    @Column(nullable = false, unique = true)
    private String transacaoId;

    @Column(nullable = false)
    private Date ultimaTransacao;

    @Column(nullable = true, name = "Registro_Dos_Saldos")
    private BigDecimal backupSaldo;

    @Column(nullable = false, name = "Registro_Das_Tentativas")
    private Integer registrosTentativas;

    @Column(nullable = false, name = "CommitAttempt")
    private Integer tentativasTransacaoConfirmada;

    @Column(nullable = false)
    private boolean transacaoRevertida;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Column(nullable = true, name = "Saldo_Anterior")
    private BigDecimal saldoAnterior;

    @Column(nullable = false, name = "Tempo_De_Transacao")
    private Long tempoTransacao;

    @Column(nullable = true)
    private String backupDados;

    @Column
    private String recursoId;

    public Long getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getMoeda() {
        return moeda;
    }

    public Long getVersao() {
        return versao;
    }

    public boolean isFaseTransacao() {
        return faseTransacao;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public Date getUltimaTransacao() {
        return ultimaTransacao;
    }

    public BigDecimal getBackupSaldo() {
        return backupSaldo;
    }

    public Integer getRegistrosTentativas() {
        return registrosTentativas;
    }

    public Integer getTentativasTransacaoConfirmada() {
        return tentativasTransacaoConfirmada;
    }

    public boolean isTransacaoRevertida() {
        return transacaoRevertida;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }

    public Long getTempoTransacao() {
        return tempoTransacao;
    }

    public String getBackupDados() {
        return backupDados;
    }

    public String getRecursoId() {
        return recursoId;
    }
}
