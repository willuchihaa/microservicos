package br.will.msUsuario.infrastructure.dto;

import br.will.msUsuario.core.domain.enums.UsuarioRole;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;

public record UsuarioData(Long id ,String nome, String email, String senha, UsuarioRole usuarioRole) {
    public UsuarioData(UsuarioEntity usuarioEntity){
        this(usuarioEntity.getId(), usuarioEntity.getNome(),usuarioEntity.getEmail(),usuarioEntity.getSenha(),usuarioEntity.getusuarioRole());
    }

}
