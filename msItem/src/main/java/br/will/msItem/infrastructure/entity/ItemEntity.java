package br.will.msItem.infrastructure.entity;

import java.time.LocalDate;
import java.util.UUID;

import br.will.msItem.core.domain.enums.ItensCategoria;
import br.will.msItem.infrastructure.dto.ItemData;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Item")
    @NoArgsConstructor

//@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int preco;
    private Integer quantidade;
    private LocalDate dataCadastro = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private ItensCategoria categoria;
    
    //padrao
    public ItemEntity(Long id, String nome, int preco, Integer quantidade, LocalDate dataCadastro,
            ItensCategoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.categoria = categoria;
    }
    public ItemEntity(String nome, int preco, Integer quantidade, LocalDate dataCadastro, ItensCategoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
        this.categoria = categoria;
    }
    public ItemEntity(Long id, String nome, int preco, Integer quantidade, LocalDate dataCadastro){
        this.id = id;
        this.nome = nome;
        this.preco = preco; 
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
    }
    //construtr que erda o dto
    public ItemEntity (ItemData data){
        this.id = data.id();
        this.nome = data.nome();
        this.preco = data.preco();
        this.quantidade = data.quantidade();
        this.dataCadastro = data.dataCadastro();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ItensCategoria getCategoria() {
        return categoria;
    }
    public void setCategoria(ItensCategoria categoria) {
        this.categoria = categoria;
    }

}


