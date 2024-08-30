package br.will.msItem.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.will.msItem.application.gateway.CreateItemGateway;
import br.will.msItem.application.usecaseimpl.DeletarItemUseCaseImpl;
import br.will.msItem.application.usecaseimpl.SalvarItemUseCaseImpl;
import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.repository.ItemEntityRepository;
import br.will.msItem.usecase.DeletarItemUseCase;
import br.will.msItem.usecase.ExistByIdUsecase;
import br.will.msItem.usecase.SalvarItemUseCase;

@Configuration
public class ItemConfiguration {
    @Bean
    public SalvarItemUseCase salvarItemUseCase(CreateItemGateway createItemGateway){
        return new SalvarItemUseCaseImpl(createItemGateway);
    }
    @Bean
    public DeletarItemUseCase deletarItemUseCase(ExistByIdUsecase existByIdUsecase,CreateItemGateway createItemGateway, ItemEntityRepository itemEntityRepository){
        return new DeletarItemUseCaseImpl(existByIdUsecase, createItemGateway, itemEntityRepository);
    }
    @Bean
    public CreateItemGateway createItemGateway(){
        return new CreateItemGateway() {

            @Override
            public Item create(Item item) {
                return null;
            }

            @Override
            public Item delete(Item item) {
                return null;
            }

            @Override
            public Item Atualizar(Item item) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'Atualizar'");
            }
            
        };
    }
    @Bean
    public ExistByIdUsecase existByIdUsecase(){
        return new ExistByIdUsecase() {

            @Override
            public boolean existsById(Long long1) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'existsById'");
            }
            
        };
    }
}
