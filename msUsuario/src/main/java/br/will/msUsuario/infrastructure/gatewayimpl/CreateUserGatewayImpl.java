package br.will.msUsuario.infrastructure.gatewayimpl;

import org.springframework.stereotype.Service;

import br.will.msUsuario.application.gateway.CreateUserGateway;
import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;
import br.will.msUsuario.infrastructure.mapper.UsuarioMapper;
import br.will.msUsuario.infrastructure.repository.UsuarioEntityRepository;

@Service//no curso o cara faz os gatewaysimpl no service
public class CreateUserGatewayImpl implements CreateUserGateway{
    
    private UsuarioEntityRepository usuarioEntityRepository;
    private UsuarioMapper usuarioMapper;
    

    public CreateUserGatewayImpl(UsuarioEntityRepository usuarioEntityRepository, UsuarioMapper usuarioMapper) {
        this.usuarioEntityRepository = usuarioEntityRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario create(Usuario usuario) {
        //criei variavel que pega metodo do mapper e salva no repositorio
        UsuarioEntity saved = usuarioEntityRepository.save(usuarioMapper.toUserEntity(usuario));
        return null;
    }
    @Override
    public Usuario delete(Usuario usuario) {
       //UsuarioEntity deleted = usuarioEntityRepository.delete(usuarioMapper.toUserEntity(usuario));
        return null;
    }

    @Override
    public Usuario upate(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upate'");
    }
    
}
