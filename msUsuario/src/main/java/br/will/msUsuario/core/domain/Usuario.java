package br.will.msUsuario.core.domain;

import java.util.Objects;
import java.util.UUID;

import br.will.msUsuario.core.domain.enums.UsuarioRole;

public class Usuario {

    public static final UsuarioRole UsuarioLogin = null;
    
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private UsuarioRole usuarioRole;

    public Usuario(Long id, String nome, String email, String senha, UsuarioRole usuarioRole) {
         this.id = id;
         this.nome = nome;
         this.email = email;
         this.senha = senha;
         this.usuarioRole = usuarioRole;
     }
    public Usuario(String nome, String email, String senha, UsuarioRole usuarioRole){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioRole = usuarioRole;
    }
    public Usuario(){

    }
    public Long getId() {
        return id;
    }


    public void setId(Long id){
        this.id = id;
    }


    public String getNome(String nome){
        return nome;
    }


    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getsenha(String senha) {
        return senha;
    }


    public void setsenha(String senha){
        this.senha = senha;
    }


    public UsuarioRole getusuarioRole(){
        return  usuarioRole;
    }
    
    //parte do detalhesusuario
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && nome.equals(usuario.nome) && Objects.equals(email, usuario.email) && senha.equals(usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha);
    }
    
    //usando no detalhesusuario
    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
    public String getSenha() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSenha'");
    }
}
