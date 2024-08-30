package br.will.msCarrinho.application.usecaseimpl;

import br.will.msCarrinho.application.gateway.CreateCarrinhoGateway;
import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.usecase.DeletarCarrinhoUseCase;
import br.will.msCarrinho.usecase.DeleteByIdUseCase;
import br.will.msCarrinho.usecase.ExistByIdUsecase;

public class DeletarCarrinhoUseCaseImpl implements DeletarCarrinhoUseCase {
    private DeleteByIdUseCase deleteByIdUseCase;
    private ExistByIdUsecase existByIdUsecase;
    private CreateCarrinhoGateway createCarrinhoGateway;

    public DeletarCarrinhoUseCaseImpl(DeleteByIdUseCase deleteByIdUseCase, ExistByIdUsecase existByIdUsecase,CreateCarrinhoGateway createCarrinhoGateway) {
        this.deleteByIdUseCase = deleteByIdUseCase;
        this.existByIdUsecase = existByIdUsecase;
        this.createCarrinhoGateway = createCarrinhoGateway;
    }

    @Override
    public Carrinho delete(Carrinho carrinho, Long id) {
        if (this.existByIdUsecase.existsById(carrinho.getId())) {
            this.createCarrinhoGateway.delete(carrinho);
            System.out.println("Carrinho apagado com sucesso");
        }
        else
        System.out.println("id ede item invalido ou nao existe");
        return carrinho;
    }
    }

    