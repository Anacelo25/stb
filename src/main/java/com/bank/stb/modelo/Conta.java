package com.bank.stb.modelo;

import com.bank.stb.enums.StatusTransacao;
import com.bank.stb.enums.TipoTransacao;
import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroConta;

    @Column(nullable = false)
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

    @Column(nullable = false)
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

    @Column
    private String recursoId;
}
