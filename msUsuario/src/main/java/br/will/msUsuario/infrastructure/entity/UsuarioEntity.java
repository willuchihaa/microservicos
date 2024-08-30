package br.will.msUsuario.infrastructure.entity;

import br.will.msUsuario.core.domain.enums.UsuarioRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id_usuario")
    private Long id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "email")
    private String email;
    @Column (name = "senha")
    private String senha;

    @Enumerated(EnumType.STRING)  
    private UsuarioRole usuarioRole;

    // construtor padrao
    public UsuarioEntity(Long id, String nome, String email, String senha, UsuarioRole usuarioRole) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioRole = usuarioRole;
    }
    //construtor buxa
    public UsuarioEntity(Long id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public UsuarioEntity(){

    }

    //userService
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getNome(){
        return nome;
    }


    public void setNome(String nome){
        this.nome = nome;
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

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public String getSenha() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSenha'");
    }

    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }

}
