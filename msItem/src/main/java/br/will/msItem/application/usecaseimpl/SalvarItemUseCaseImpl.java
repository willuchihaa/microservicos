package br.will.msItem.application.usecaseimpl;

import br.will.msItem.application.gateway.CreateItemGateway;
import br.will.msItem.core.domain.Item;
import br.will.msItem.core.domain.enums.ItensCategoria;
import br.will.msItem.usecase.ExistByIdUsecase;
import br.will.msItem.usecase.SalvarItemUseCase;

public class SalvarItemUseCaseImpl implements SalvarItemUseCase {
    private CreateItemGateway createItemGateway;

public SalvarItemUseCaseImpl(CreateItemGateway createItemGateway){
    this.createItemGateway = createItemGateway;

}
@Override
public void saveItem(Item item, String nome, int preco, Integer quantidade ,ItensCategoria itensCategoria,boolean IsAdmin) {
    if (IsAdmin == true) {
        var itemSalvo = createItemGateway.create(item);
    } else if (IsAdmin == false) {
        System.out.println("so pode salvar item se for ADM!");
    }
}
}
