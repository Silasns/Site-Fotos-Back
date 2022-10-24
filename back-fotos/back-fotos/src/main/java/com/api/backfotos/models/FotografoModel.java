package com.api.backfotos.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_FOTOGRAFOS")
public class FotografoModel extends PessoaModel {

    @OneToOne
    @JoinColumn(name = "numConta", nullable = false)
    private ContaModel conta;

    @Column
    private String saldo;//ou String?

    public ContaModel getConta() {
        return conta;
    }

    public void setConta(ContaModel conta) {
        this.conta = conta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
