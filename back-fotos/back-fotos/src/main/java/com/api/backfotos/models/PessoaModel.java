package com.api.backfotos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
@MappedSuperclass
@Table(name="TB_USUARIOS")
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String genero;//Fazer enum

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private String DDD;

    @Column(nullable = false)
    private String numTel;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String
                                          dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
