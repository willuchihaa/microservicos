package br.will.msItem.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.entity.ItemEntity;


public interface ItemEntityRepository extends JpaRepository <ItemEntity, Long>{
    //service metodo
    void save(Item i);

    Optional<Item> findByNome(String nome);

    
}
