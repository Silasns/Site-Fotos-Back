package com.api.backfotos.models;

import com.api.backfotos.services.MoedaService;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_FOTOGRAFOS")
public class FotografoModel extends UsuarioModel {

    @OneToOne
    @JoinColumn(name = "numConta", nullable = false)
    private ContaModel conta;

    @Column
    private BigDecimal saldo;//ou String?


}
