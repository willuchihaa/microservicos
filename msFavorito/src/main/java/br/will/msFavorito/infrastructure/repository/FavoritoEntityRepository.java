package br.will.msFavorito.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.will.msFavorito.infrastructure.entity.FavoritoEntity;



public interface FavoritoEntityRepository extends JpaRepository <FavoritoEntity, Long>{
    
}
