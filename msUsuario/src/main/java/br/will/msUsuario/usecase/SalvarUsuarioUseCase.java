package br.will.msUsuario.usecase;

import br.will.msUsuario.core.domain.Usuario;

public interface SalvarUsuarioUseCase {
    void criarUsuario(Usuario usuario,String nome, String email, String senha, boolean isAdmin);
}
