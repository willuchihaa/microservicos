package br.will.msItem.usecase;

import br.will.msItem.core.domain.Item;
import br.will.msItem.core.domain.enums.ItensCategoria;

public interface SalvarItemUseCase {
    void saveItem (Item item, String nome, int preco, Integer quantidade ,ItensCategoria itensCategoria,boolean IsAdmin);
}
