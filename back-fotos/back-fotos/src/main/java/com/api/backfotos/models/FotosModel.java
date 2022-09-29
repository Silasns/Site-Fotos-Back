package com.api.backfotos.models;

import javax.persistence.*;

@Entity
@Table(name="TB_FOTOS")
public class FotosModel {

    @Id
    @Column(nullable = false)
    private String idFoto;

    @OneToOne
    @JoinColumn()
    private FotografoModel fotografo;

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public FotografoModel getFotografo() {
        return fotografo;
    }

    public void setFotografo(FotografoModel fotografo) {
        this.fotografo = fotografo;
    }
}
