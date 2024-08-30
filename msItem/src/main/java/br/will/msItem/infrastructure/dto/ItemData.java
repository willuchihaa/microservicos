package br.will.msItem.infrastructure.dto;

import java.time.LocalDate;

import br.will.msItem.core.domain.enums.ItensCategoria;
import br.will.msItem.infrastructure.entity.ItemEntity;

public record ItemData(Long id, String nome, int preco, Integer quantidade, LocalDate dataCadastro,ItensCategoria categoria) {
    public ItemData ItensData(ItemEntity itemEntity){
        return new ItemData(itemEntity.getId(), itemEntity.getNome(),itemEntity.getPreco(),itemEntity.getQuantidade(),itemEntity.getDataCadastro(),itemEntity.getCategoria());
    }
}
