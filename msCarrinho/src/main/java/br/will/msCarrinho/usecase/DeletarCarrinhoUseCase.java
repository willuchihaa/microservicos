package br.will.msCarrinho.usecase;

import br.will.msCarrinho.core.domain.Carrinho;

public interface DeletarCarrinhoUseCase {
    Carrinho delete (Carrinho carrinho, Long id);
}
