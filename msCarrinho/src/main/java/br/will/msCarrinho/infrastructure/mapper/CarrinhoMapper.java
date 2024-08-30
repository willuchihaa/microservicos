package br.will.msCarrinho.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.infrastructure.dto.CarrinhoData;
import br.will.msCarrinho.infrastructure.entity.CarrinhoEntity;

@Component
public class CarrinhoMapper {
    public CarrinhoEntity toCarrinhoEntity(Carrinho carrinho){
        return new CarrinhoEntity(carrinho.getId(),carrinho.getNome(),carrinho.getPreco(),carrinho.getQuantidade());
    }
    public Carrinho toCarrinho(CarrinhoData carrinhoData){
        return new Carrinho(carrinhoData.id(),carrinhoData.nome(),carrinhoData.preco(),carrinhoData.Quantidade());
    }
}
