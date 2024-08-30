package br.will.msCarrinho.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.will.msCarrinho.application.gateway.CreateCarrinhoGateway;
import br.will.msCarrinho.application.usecaseimpl.DeletarCarrinhoUseCaseImpl;
import br.will.msCarrinho.application.usecaseimpl.SalvarCarrinhoUseCaseImpl;
import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.usecase.DeletarCarrinhoUseCase;
import br.will.msCarrinho.usecase.DeleteByIdUseCase;
import br.will.msCarrinho.usecase.ExistByIdUsecase;
import br.will.msCarrinho.usecase.SalvarCarrinhoUseCase;

@Configuration

public class CarrinhoConfig {
    //criar os beans
    @Bean 
    public ExistByIdUsecase existByIdUsecase(){
        return new ExistByIdUsecase(){

            @Override
            public boolean existsById(Long long1) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'existsById'");
            }
            
        };
    }
    @Bean
    public SalvarCarrinhoUseCase salvarCarrinhoUseCase(ExistByIdUsecase existByIdUsecase, CreateCarrinhoGateway carrinhoGateway){
        return new SalvarCarrinhoUseCaseImpl(existByIdUsecase, carrinhoGateway);
    }

    @Bean 
    public DeletarCarrinhoUseCase deletarCarrinhoUseCase(DeleteByIdUseCase deletarCarrinhoUseCase, ExistByIdUsecase existByIdUsecase, CreateCarrinhoGateway createCarrinhoGateway  ){
        return new DeletarCarrinhoUseCaseImpl(deletarCarrinhoUseCase, existByIdUsecase, createCarrinhoGateway);
    }

    @Bean
    public CreateCarrinhoGateway carrinhoGateway(){
        return new CreateCarrinhoGateway() {

            @Override
            public Carrinho create(Carrinho carrinho) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'create'");
            }

            @Override
            public Carrinho delete(Carrinho carrinho) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'delete'");
            }

            @Override
            public Carrinho Atualizar(Carrinho carrinho) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'Atualizar'");
            }
            
        };

    }
    @Bean
    public DeleteByIdUseCase deleteByIdUseCase(){
        return new DeleteByIdUseCase() {

            @Override
            public void deleteById(Carrinho carrinho) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
            }
            
        };
    }
}
