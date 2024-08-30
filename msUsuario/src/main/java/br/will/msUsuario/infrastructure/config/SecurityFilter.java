package br.will.msUsuario.infrastructure.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.will.msUsuario.core.domain.Usuario;
import br.will.msUsuario.infrastructure.entity.DetalhesUsuario;
import br.will.msUsuario.infrastructure.entity.UsuarioEntity;
import br.will.msUsuario.infrastructure.repository.UsuarioEntityRepository;
import br.will.msUsuario.infrastructure.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    UsuarioEntityRepository usuarioEntityRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{

        String token = this.recoverToken(request);
        if (token != null) {
            tokenService.validarToken(token);//era pra ta token mas
            //essa coisa tem que ta no usaurio(dominio)
            UserDetails user = new DetalhesUsuario((Usuario)usuarioEntityRepository.findByNome(tokenService.PegarToken(token)));
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            
        }
        filterChain.doFilter(request, response);
    }

        private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null){
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }}
