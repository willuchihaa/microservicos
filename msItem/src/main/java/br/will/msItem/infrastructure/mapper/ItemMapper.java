package br.will.msItem.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.dto.ItemData;
import br.will.msItem.infrastructure.entity.ItemEntity;

@Component
public class ItemMapper {
    public ItemEntity toItemEntity(Item item){
        return new ItemEntity(item.getId(),
        item.getNome(null),
        item.getPreco(),
        item.getQuantidade(),
        item.getDataCadastro());
    }
    public Item toItem(ItemData data){
        return new Item(data.id(),data.nome(),data.preco(),data.quantidade(),data.dataCadastro(),data.categoria());
    }
}
