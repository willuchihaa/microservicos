package br.will.msItem.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.will.msItem.core.domain.Item;
import br.will.msItem.infrastructure.dto.ItemData;
import br.will.msItem.infrastructure.dto.response.BaseResponse;
import br.will.msItem.infrastructure.entity.ItemEntity;
import br.will.msItem.infrastructure.mapper.ItemMapper;
import br.will.msItem.infrastructure.repository.ItemEntityRepository;
import br.will.msItem.infrastructure.service.ItemService;
import br.will.msItem.usecase.DeletarItemUseCase;
import br.will.msItem.usecase.SalvarItemUseCase;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/item")
public class ItemController {
    private ItemMapper itemMapper;
    private SalvarItemUseCase salvarItemUseCase;
    private DeletarItemUseCase deletarItemUseCase;
    private ItemService itemService;

    public ItemController(ItemMapper itemMapper, SalvarItemUseCase salvarItemUseCase,
            DeletarItemUseCase deletarItemUseCase , ItemService itemService) {
        this.itemMapper = itemMapper;
        this.salvarItemUseCase = salvarItemUseCase;
        this.deletarItemUseCase = deletarItemUseCase;
        this.itemService = itemService;
    }
    @PostMapping("/CriarItem")
    @Transactional
    public BaseResponse<String> criarItem(@RequestBody ItemData data, @RequestParam boolean isAdmin){
        
        ResponseEntity<ItemEntity> item = itemService.addItem(data, isAdmin);
        
    return BaseResponse.<String>builder().success(true).message("item creado").build();

}
    @DeleteMapping("/{id}")
    @Transactional
    public void DeletarItem(Long id, @RequestParam boolean isAdmin){
        if (isAdmin) {
            itemService.DeletarItem(id, isAdmin);
        }else{
            throw new RuntimeException("Você não tem permissão para deletar um item");
        }
    }
    @GetMapping("/{id}")
    @Transactional
    public ItemEntity buscarPorId(@PathVariable Long id){
        return itemService.BuscarPorId(id);
    }
}
