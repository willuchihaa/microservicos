package br.will.msUsuario.application.usecaseimpl;

import br.will.msUsuario.application.gateway.CreateUserGateway;
import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.usecase.SalvarUsuarioUseCase;

public class SalvarUsuarioUseCaseImpl implements SalvarUsuarioUseCase{
    private CreateUserGateway createUserGateway;

    public SalvarUsuarioUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }
    @Override
    public void criarUsuario(Usuario usuario, String nome, String email, String senha, boolean isAdmin) {
        if (isAdmin == true) {
            this.createUserGateway.create(usuario);
            System.out.println("Usuario Adm criado");
        } if (isAdmin == false) {
            this.createUserGateway.create(usuario);
            System.out.println("Usuario comum criado");

        } else {
            System.out.println("falha em criar");

        }
        // if (this.existByIdUseCase.existsById(usuario.getId()) && !isAdmin) {
        //     this.createUserGateway.create(usuario);
        //     System.out.println("Usuario Salvo com sucesso!");
        //tenho que por pra dar erro
    }
}
