package com.bank.stb.transacoes;

import jakarta.persistence.*;

@Entity
@Table(name = "Registro De Transações")
public class RegistroTransacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
