package br.will.msFavorito.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.will.msFavorito.core.domain.Favorito;
import br.will.msFavorito.infrastructure.dto.FavoritoData;
import br.will.msFavorito.infrastructure.entity.FavoritoEntity;

@Component
public class FavoritoMapper {
    public FavoritoEntity toFavoritoEntity(Favorito favorito){
        return new FavoritoEntity(favorito.getId(),favorito.getNome());
    }
    public Favorito toFavorito(FavoritoData favoritoData){
        return new Favorito(favoritoData.id(), favoritoData.nome());
    }
}
