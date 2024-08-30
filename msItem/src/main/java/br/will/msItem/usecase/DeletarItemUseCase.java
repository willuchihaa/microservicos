package br.will.msItem.usecase;

import br.will.msItem.core.domain.Item;

public interface DeletarItemUseCase {
    void deletarItem(Item item,Long id, boolean isAdmin);
}
