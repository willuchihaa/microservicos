package br.will.msUsuario.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.dto.UsuarioData;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;

@Component
public class UsuarioMapper {
    public UsuarioEntity toUserEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getId(),
        usuario.getNome(null),
        usuario.getEmail(),
        usuario.getsenha(null));
    }

    public Usuario toUser(UsuarioData data) {
        return new Usuario(data.id(),data.nome(),data.email(),data.senha(),data.usuarioRole());
    }
}
