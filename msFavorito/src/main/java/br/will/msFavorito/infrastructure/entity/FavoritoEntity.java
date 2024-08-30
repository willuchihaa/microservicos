package br.will.msFavorito.infrastructure.entity;

import java.util.UUID;

import br.will.msFavorito.infrastructure.dto.FavoritoData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favoritos")
//@AllArgsConstructor
@NoArgsConstructor
public class FavoritoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "nome")
    private String nome;
    
    public FavoritoEntity(String nome) {
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public FavoritoEntity(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }
    public FavoritoEntity(FavoritoData data){
        this.id = data.id();
        this.nome = data.nome();
    }
}
