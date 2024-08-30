package br.will.msCarrinho.application.gateway;

import br.will.msCarrinho.core.domain.Carrinho;

public interface CreateCarrinhoGateway {
    Carrinho create(Carrinho carrinho);

    Carrinho delete(Carrinho carrinho);

    Carrinho Atualizar(Carrinho carrinho);
}
