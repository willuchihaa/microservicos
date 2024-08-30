package br.will.msUsuario.application.usecaseimpl;

import br.will.msUsuario.application.gateway.CreateUserGateway;
import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.repository.UsuarioEntityRepository;
import br.will.msUsuario.usecase.DeletarUsuarioUseCase;
import jakarta.persistence.EntityNotFoundException;

public class DeletarUsuarioUseCaseImpl implements DeletarUsuarioUseCase {
    private CreateUserGateway createUserGateway;
    private UsuarioEntityRepository usuarioEntityRepository;

    public DeletarUsuarioUseCaseImpl(CreateUserGateway createUserGateway, UsuarioEntityRepository usuarioEntityRepository) {
        this.createUserGateway = createUserGateway;
        this.usuarioEntityRepository = usuarioEntityRepository;
    }

    @Override
    public void deletarUsuario(Usuario usuario, Long id) {
        if (usuarioEntityRepository.existsById(id)) {
            usuarioEntityRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("id de usuario nao encontrado");
        }
        
    }

}
