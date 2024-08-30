package br.will.msFavorito.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import br.will.msFavorito.application.gateway.CreateFavoritoGateway;
import br.will.msFavorito.application.usecaseimpl.DeletarFavoritoUseCaseImpl;
import br.will.msFavorito.application.usecaseimpl.SalvarFavoritoUseCaseImpl;
import br.will.msFavorito.core.domain.Favorito;
import br.will.msFavorito.infrastructure.repository.FavoritoEntityRepository;
import br.will.msFavorito.usecase.DeletarFavoritoUseCase;
import br.will.msFavorito.usecase.ExistByIdUseCase;
import br.will.msFavorito.usecase.SalvarFavoritoUseCase;

@Configuration
public class FavoritoConfig {
    
    @Bean
    public SalvarFavoritoUseCase salvarFavoritoUseCase( CreateFavoritoGateway createFavoritoGateway, ExistByIdUseCase existByIdUseCase ){
        return new SalvarFavoritoUseCaseImpl(createFavoritoGateway, existByIdUseCase);
}   
@Bean 
public ExistByIdUseCase existByIdUseCase(){
    return new ExistByIdUseCase() {

        @Override
        public boolean existsById(Long long1) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'existsById'");
        }
    };
}   
@Bean
    public DeletarFavoritoUseCase deletarFavoritoUseCase(CreateFavoritoGateway createFavoritoGateway, FavoritoEntityRepository favoritoEntityRepository, ExistByIdUseCase existByIdUseCase){
        return new DeletarFavoritoUseCaseImpl(createFavoritoGateway, favoritoEntityRepository, existByIdUseCase);
    }

    @Bean
    public CreateFavoritoGateway createFavoritoGateway(){
        return new CreateFavoritoGateway() {

            @Override
            public Favorito salvar(Favorito favorito) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'salvar'");
            }

            @Override
            public Favorito deletar(Favorito favorito) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'deletar'");
            }
            
        };
        
    }
    
}
