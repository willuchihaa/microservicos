package br.will.msCarrinho.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.infrastructure.dto.CarrinhoData;
import br.will.msCarrinho.infrastructure.entity.CarrinhoEntity;


public interface CarrinhoEntityRepository extends JpaRepository <CarrinhoEntity, Long>{

    void save(Carrinho c);

    CarrinhoEntity getReferenceById(Long id);
    
}
