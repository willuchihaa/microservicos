package br.will.msItem.application.usecaseimpl;

import br.will.msItem.application.gateway.CreateItemGateway;
import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.repository.ItemEntityRepository;
import br.will.msItem.usecase.DeletarItemUseCase;
import br.will.msItem.usecase.ExistByIdUsecase;

public class DeletarItemUseCaseImpl implements DeletarItemUseCase{
  private CreateItemGateway createItemGateway;
  private ExistByIdUsecase existsByIdUsecase;
  private ItemEntityRepository itemEntityRepository;


public DeletarItemUseCaseImpl(ExistByIdUsecase existByIdUsecase, CreateItemGateway createItemGateway, ItemEntityRepository itemEntityRepository){
    this.createItemGateway = createItemGateway;
    this.existsByIdUsecase = existByIdUsecase;
    this.itemEntityRepository = itemEntityRepository;
}

@Override
public void deletarItem(Item item, Long id,boolean isAdmin) {
    if (itemEntityRepository.existsById(id) && isAdmin == true) {
        var itemDeletar = createItemGateway.delete(item);

    }else if (isAdmin == false) {
        System.out.println("so pode deletar um item se for ADM!");
    }
}

}
