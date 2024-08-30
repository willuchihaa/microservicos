package br.will.msFavorito.core.domain;

import java.util.UUID;

public class Favorito {
     private Long id;
    private String nome;
    //construtor padrao e do mapper
    public Favorito(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

}
