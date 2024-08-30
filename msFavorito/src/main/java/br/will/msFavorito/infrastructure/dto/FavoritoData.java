package br.will.msFavorito.infrastructure.dto;

import br.will.msFavorito.infrastructure.entity.FavoritoEntity;

public record FavoritoData(Long id, String nome) {
    public FavoritoData(FavoritoEntity favoritoEntity){
        this(favoritoEntity.getId(),favoritoEntity.getNome());
    }
}
