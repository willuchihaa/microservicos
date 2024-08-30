package br.will.msUsuario.usecase;

import br.will.msUsuario.core.domain.Usuario;

public interface DeletarUsuarioUseCase {
    void deletarUsuario(Usuario usuario, Long id);
}
