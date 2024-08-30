package br.will.msUsuario.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.will.msUsuario.application.gateway.CreateUserGateway;
import br.will.msUsuario.application.usecaseimpl.DeletarUsuarioUseCaseImpl;
import br.will.msUsuario.application.usecaseimpl.SalvarUsuarioUseCaseImpl;
import br.will.msUsuario.usecase.DeletarUsuarioUseCase;
import br.will.msUsuario.usecase.SalvarUsuarioUseCase;

@Configuration
public class UserConfig {
    /*criar esse config pro usecase do controller, pq como foi criado
     * na camada application, logo ospring nao identifica ela
     */
    @Bean
    public SalvarUsuarioUseCase salvarUsuarioUseCase(CreateUserGateway createUserGateway){
        return new SalvarUsuarioUseCaseImpl(createUserGateway);

    }
    //ou faz igual ta o abaixo
    @Bean
     public DeletarUsuarioUseCase deletarUsuarioUseCase(CreateUserGateway createUserGateway){
        return new DeletarUsuarioUseCaseImpl(createUserGateway, null);
     }
    // @Bean
    // public DeletarUsuarioUseCase deletarUsuarioUseCase(){
    //     return new DeletarUsuarioUseCase() {

    //         @Override
    //         public void delete(Usuario usuario, Long id) {
    //             // TODO Auto-generated method stub
    //             throw new UnsupportedOperationException("Unimplemented method 'delete'");
    //         }
            
    //     };
    }


