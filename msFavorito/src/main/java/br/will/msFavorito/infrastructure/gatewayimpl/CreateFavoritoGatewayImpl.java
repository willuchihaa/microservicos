package br.will.msFavorito.infrastructure.gatewayimpl;

import br.will.msFavorito.application.gateway.CreateFavoritoGateway;
import br.will.msFavorito.core.domain.Favorito;
import br.will.msFavorito.infrastructure.entity.FavoritoEntity;
import br.will.msFavorito.infrastructure.mapper.FavoritoMapper;
import br.will.msFavorito.infrastructure.repository.FavoritoEntityRepository;


public class CreateFavoritoGatewayImpl implements CreateFavoritoGateway {
    private FavoritoEntityRepository favoritoEntityRepository;
    public FavoritoMapper favoritoMapper;
    
    public CreateFavoritoGatewayImpl(FavoritoEntityRepository favoritoEntityRepository, FavoritoMapper favoritoMapper){
        this.favoritoEntityRepository = favoritoEntityRepository;
        this.favoritoMapper = favoritoMapper;
    }
    @Override
    public Favorito salvar(Favorito favorito) {
        FavoritoEntity saved = favoritoEntityRepository.save(favoritoMapper.toFavoritoEntity(favorito));
        return null;
    }

    @Override
    public Favorito deletar(Favorito favorito) {
        return null;
        //FavoritoEntity deleted = favoritoEntityRepository.delete(null);
    }

    }
    

