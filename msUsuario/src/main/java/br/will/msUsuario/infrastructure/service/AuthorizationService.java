package br.will.msUsuario.infrastructure.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.entity.DetalhesUsuario;
import br.will.msUsuario.infrastructure.repository.UsuarioEntityRepository;



@Service
public class AuthorizationService implements UserDetailsService{
    @Autowired
    private UsuarioEntityRepository userEntityRepository;



    // sobrescreve algus metodos do userdetails<LoadByUsername>
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = userEntityRepository.findByNome(username);
        DetalhesUsuario ud = new DetalhesUsuario(u);
        System.out.println(u.getSenha());
       return ud;
    }
}