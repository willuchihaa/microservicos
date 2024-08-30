package br.will.msItem.infrastructure.gatewayimpl;

import br.will.msItem.application.gateway.CreateItemGateway;
import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.entity.ItemEntity;
import br.will.msItem.infrastructure.mapper.ItemMapper;
import br.will.msItem.infrastructure.repository.ItemEntityRepository;

public class CreateItemGatewayImpl implements CreateItemGateway{
    private ItemMapper itemMapper;
    private ItemEntityRepository itemEntityRepository;
    public CreateItemGatewayImpl(ItemEntityRepository itemEntityRepository,ItemMapper itemMapper) {
        this.itemEntityRepository = itemEntityRepository;
      this.itemMapper = itemMapper;
    }
    @Override
    public Item create(Item item) {
        ItemEntity itemSaved  = itemEntityRepository.save(itemMapper.toItemEntity(item));
        return null;
    }

    @Override
    public Item delete(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Item Atualizar(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Atualizar'");
    }

    }
 