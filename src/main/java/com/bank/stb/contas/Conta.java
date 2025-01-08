package com.bank.stb.contas;

import com.bank.stb.enums.StatusTransacao;
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

    @Column(nullable = false)
    private String transacaoId;

    @Column(nullable = false)
    private Date ultimaTransacao;

    @Column(nullable = false)
    private boolean registroConfirmado;

    @Column(nullable = true)
    private BigDecimal backupSaldo;

    @Column(nullable = false)
    private Integer registrosTentativas;

}
