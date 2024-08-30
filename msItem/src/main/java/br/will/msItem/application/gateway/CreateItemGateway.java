package br.will.msItem.application.gateway;

import br.will.msItem.core.domain.Item;

public interface CreateItemGateway {
    Item create(Item item);
    Item delete(Item item);
    Item Atualizar(Item item);
}
