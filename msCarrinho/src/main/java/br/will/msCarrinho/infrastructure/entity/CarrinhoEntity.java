package br.will.msCarrinho.infrastructure.entity;

import java.io.Serializable;
import java.util.UUID;

import br.will.msCarrinho.infrastructure.dto.CarrinhoData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "carrinho")
@NoArgsConstructor

public class CarrinhoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int preco;
    private Integer quantidade;
    
    
    
    public CarrinhoEntity(String nome, int preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public CarrinhoEntity(Long id, String nome, int preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //service do carrinho pediu
    public CarrinhoEntity(CarrinhoData data) {
        this.id = data.id();
        this.nome = data.nome();
        this.preco = data.preco();
        this.quantidade = data.Quantidade();
    }

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

    public int getPreco(){
        return preco;
    }

    public void setPreco(int preco){
        this.preco = preco;
    }

    public Integer getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public void updatee(CarrinhoData data) {
        this.nome = data.nome();
    }
    
 }
