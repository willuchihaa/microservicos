package br.will.msUsuario.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;

//passa o nome do model/entity e a chave(nao sei se é UUID ou Long)
public interface UsuarioEntityRepository extends JpaRepository <UsuarioEntity, Long> {

    Usuario findByNome(String username);

    Usuario save(Usuario usuario);
    
}
