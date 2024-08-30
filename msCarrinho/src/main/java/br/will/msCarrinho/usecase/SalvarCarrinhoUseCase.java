package br.will.msCarrinho.usecase;

import br.will.msCarrinho.core.domain.Carrinho;

public interface SalvarCarrinhoUseCase {
    void criarCarrinho(Carrinho carrinho, String nome, int preco, Integer quantidade);
}
