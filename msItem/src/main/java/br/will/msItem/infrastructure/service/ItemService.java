package br.will.msItem.infrastructure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.dto.ItemData;
import br.will.msItem.infrastructure.entity.ItemEntity;
import br.will.msItem.infrastructure.repository.ItemEntityRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class ItemService {
    @Autowired
    private ItemEntityRepository itemEntityRepository;


    public ResponseEntity<ItemEntity> addItem(@RequestBody ItemData data, boolean isAdmin) {
        if(isAdmin) {
            ItemEntity i = new ItemEntity(data);
            itemEntityRepository.save(i);
            System.out.println("Item salvo com sucesso\n"+data);
        }else{
            throw new RuntimeException("Somente admins podem adicionar itens");
        }
        return null;
    }

    public Item PesquisarNome(String nome) {
        Optional<Item> item = itemEntityRepository.findByNome(nome);
        if(item.isPresent()) {
            return item.get();
     }
     return null;
}

public ItemEntity BuscarPorId(@PathVariable Long id) {
    Optional<ItemEntity> item = itemEntityRepository.findById(id);
    return item.orElse(null);
}
public ItemEntity DeletarItem(@PathVariable Long id, boolean isAdmin) {
    if(isAdmin) {
        itemEntityRepository.existsById(id);
        itemEntityRepository.deleteById(id);
    }else{
        throw new RuntimeException("Você não tem permissão para deletar um item");
    }
    return null;
}

}
