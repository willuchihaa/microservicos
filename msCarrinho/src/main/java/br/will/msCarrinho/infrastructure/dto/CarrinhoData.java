package br.will.msCarrinho.infrastructure.dto;

import br.will.msCarrinho.infrastructure.entity.CarrinhoEntity;

public record CarrinhoData(Long id, String nome, int preco, Integer Quantidade) {
    public CarrinhoData(CarrinhoEntity carrinhoEntity){
        this(carrinhoEntity.getId(),carrinhoEntity.getNome(),carrinhoEntity.getPreco(),carrinhoEntity.getQuantidade());
    }

    
}
