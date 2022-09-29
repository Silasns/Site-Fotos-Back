package com.api.backfotos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="TB_PROVAS")
public class ProvaModel implements Serializable {

    private static final long  serialVersionUID =1L;

    @Id
    @Column(nullable = false, unique = true)
    private String Nome;

    @Column(nullable = false)
    private Date dataProva;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column(nullable = false)
    private String tipoProva;// Criar enum

    @OneToOne
    @JoinColumn(name = "idFoto", nullable = false)
    private FotosModel fotos;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTipoProva() {
        return tipoProva;
    }

    public void setTipoProva(String tipoProva) {
        this.tipoProva = tipoProva;
    }

    public FotosModel getFotos() {
        return fotos;
    }

    public void setFotos(FotosModel fotos) {
        this.fotos = fotos;
    }
}
