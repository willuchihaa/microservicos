package br.will.msCarrinho.core.domain;

import java.util.UUID;


public class Carrinho {
    private Long id;
    private String nome;
    private int preco;
    private Integer quantidade;
    //construtor padrao e do mapper
    public Carrinho(Long id, String nome, int preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Carrinho(String nome, int preco, Integer quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPreco() {
        return preco;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    //salvarCarrinhoUseCaseImpl
    public Carrinho() {
        //TODO Auto-generated constructor stub
    }//do DeletarCarrinhoUseCaseImpl
    public Long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
}
}

