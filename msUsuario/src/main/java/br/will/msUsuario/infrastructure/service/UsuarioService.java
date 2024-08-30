package br.will.msUsuario.infrastructure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;
import br.will.msUsuario.infrastructure.repository.UsuarioEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioEntityRepository usuarioEntityRepository;
    // @Autowired
    // BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public Usuario save(@Valid Usuario usuarioData, @RequestParam boolean isAdmin) {
        Usuario usuario = new Usuario(null, null, null, null);
        usuario.setNome(usuarioData.getNome(null));
        usuario.setsenha(usuarioData.getsenha(null));
        // usuario.setEmail(usuarioData.email());
        // usuario.setNome(usuarioData.nome());


        //usuario.getsenha(bCryptPasswordEncoder.encode(usuarioData.getsenha(null)));



        // if (usuarioEntityRepository.existsById(usuario.getNome())) {
        // throw new DataIntegrityViolationException("esse usuario existe");
        // }

        if (isAdmin) {
            return usuarioEntityRepository.save(usuario);
            
        }
        throw new EntityNotFoundException("nome de usuario nao foi encontrado");
    }

    public UsuarioEntity updateById(Long id, @Valid Usuario atualizarUser) {
        Optional<UsuarioEntity> user = usuarioEntityRepository.findById(id);
        System.out.println(user.isPresent());
        if (user.isPresent()) {
            System.out.println(user.get().getNome());
            user.get().setNome(atualizarUser.getNome(null));

            // user.get().setNome(atualizarUser.getNome());
            // user.get().setEmail(atualizarUser.getEmail());
            // user.get().getsenha(bCryptPasswordEncoder.encode(atualizarUser.getSenha()));
            // user.get().setUsuarioRole(atualizarUser.getUsuarioRole());
        }
        return usuarioEntityRepository.save(user.get());
    }

    public Usuario deleteById(@PathVariable Long id) {
        if (usuarioEntityRepository.existsById(id)) {
            usuarioEntityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("id de usuario nao encontrado");
        }
        return null;
    }

    public Object findByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }

    
}
