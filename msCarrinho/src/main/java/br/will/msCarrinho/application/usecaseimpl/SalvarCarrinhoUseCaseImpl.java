package br.will.msCarrinho.application.usecaseimpl;

import br.will.msCarrinho.application.gateway.CreateCarrinhoGateway;
import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.usecase.ExistByIdUsecase;
import br.will.msCarrinho.usecase.SalvarCarrinhoUseCase;

public class SalvarCarrinhoUseCaseImpl implements SalvarCarrinhoUseCase{
    private ExistByIdUsecase existByIdUsecase;
    private CreateCarrinhoGateway createCarrinhoGateway;
    
    public SalvarCarrinhoUseCaseImpl(ExistByIdUsecase existByIdUsecase, CreateCarrinhoGateway createCarrinhoGateway) {
        this.existByIdUsecase = existByIdUsecase;
        this.createCarrinhoGateway = createCarrinhoGateway;
    }

    @Override
    public void criarCarrinho(Carrinho carrinho, String nome, int preco, Integer quantidade) {
        if (this.existByIdUsecase.existsById(carrinho.getId())) { 
            Carrinho carrinhoSaved = this.createCarrinhoGateway.create(new Carrinho());
            System.out.println("Carrinho criado com sucesso");
        }
    }
} 
