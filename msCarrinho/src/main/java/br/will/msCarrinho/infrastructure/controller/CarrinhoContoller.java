package br.will.msCarrinho.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.infrastructure.dto.CarrinhoData;
import br.will.msCarrinho.infrastructure.dto.response.BaseResponse;
import br.will.msCarrinho.infrastructure.entity.CarrinhoEntity;
import br.will.msCarrinho.infrastructure.mapper.CarrinhoMapper;
import br.will.msCarrinho.infrastructure.service.CarrinhoService;
import br.will.msCarrinho.usecase.DeletarCarrinhoUseCase;
import br.will.msCarrinho.usecase.SalvarCarrinhoUseCase;
import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/carrinho")
public class CarrinhoContoller {
    public CarrinhoMapper carrinhoMapper;
    public SalvarCarrinhoUseCase salvarCarrinhoUseCase;
    public DeletarCarrinhoUseCase deletarCarrinhoUseCase;
    public CarrinhoService carrinhoService;

    public CarrinhoContoller(SalvarCarrinhoUseCase salvarCarrinhoUseCase,DeletarCarrinhoUseCase deletarCarrinhoUseCase, CarrinhoMapper carrinhoMapper, CarrinhoService carrinhoService) {
        this.salvarCarrinhoUseCase = salvarCarrinhoUseCase;
        this.deletarCarrinhoUseCase = deletarCarrinhoUseCase;
        this.carrinhoMapper = carrinhoMapper;
        this.carrinhoService = carrinhoService;
    }

    
    @PostMapping("/CriarCarrinho")
    @Transactional
    public BaseResponse<String> criarCarrinho (@RequestBody CarrinhoData data) {
        System.out.println("inicio da criacao do carrinho, carrinhocontroller");
        
    ResponseEntity<CarrinhoEntity> carrinho = carrinhoService.salvaItem(null, data);      
        System.out.println("carrinho criado, carrinhocontroller");
        return BaseResponse.<String>builder().success(true).message("carrinho creado").build();        
        
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletarItem(@PathVariable Long id){
        if(id != null){
            carrinhoService.deletarItem(id);
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public BaseResponse<String> atualizarItem(@PathVariable Long id, @RequestBody CarrinhoData carrinhoData){

            ResponseEntity<CarrinhoEntity> c = carrinhoService.atualizarItem(id, carrinhoData);

            return BaseResponse.<String>builder().success(true).message("carrinho atualizado").build();        

        }
    }
    
