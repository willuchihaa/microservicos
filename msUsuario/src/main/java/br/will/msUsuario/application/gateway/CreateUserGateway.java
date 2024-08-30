package br.will.msUsuario.application.gateway;

import br.will.msUsuario.core.domain.Usuario;

public interface CreateUserGateway {
    Usuario create(Usuario var1);

    Usuario delete(Usuario var1);

    Usuario upate(Usuario var1);
}
