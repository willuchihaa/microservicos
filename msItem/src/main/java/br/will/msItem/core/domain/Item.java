package br.will.msItem.core.domain;

import java.time.LocalDate;
import java.util.UUID;

import br.will.msItem.core.domain.enums.ItensCategoria;
import br.will.msItem.infrastructure.dto.ItemData;

public class Item {
    private Long id;
    private String nome;
    private int preco;
    private Integer quantidade;
    private LocalDate dataCadastro = LocalDate.now();
    private ItensCategoria categoria;

    public Item(String nome, int preco, Integer quantidade, LocalDate dataCadastro, ItensCategoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.categoria = categoria;
    }

    public Item(Long id, String nome, int preco, Integer quantidade, LocalDate dataCadastro, ItensCategoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.categoria = categoria;
    }
    //construtor do service
    public Item(ItemData data) {
        //TODO Auto-generated constructor stub
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(int preco) {
        this.preco = preco;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public void setCategoria(ItensCategoria categoria) {
        this.categoria = categoria;
    }



    public Long getId() {
        return id;
    }
    public String getNome(String nome) {
        return nome;
    }
    public int getPreco() {
        return preco;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public ItensCategoria getCategoria() {
        return categoria;
    }

}
