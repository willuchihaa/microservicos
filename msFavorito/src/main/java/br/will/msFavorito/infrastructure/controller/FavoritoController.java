package br.will.msFavorito.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.msFavorito.infrastructure.dto.FavoritoData;
import br.will.msFavorito.infrastructure.dto.response.BaseResponse;
import br.will.msFavorito.infrastructure.entity.FavoritoEntity;
import br.will.msFavorito.infrastructure.mapper.FavoritoMapper;
import br.will.msFavorito.infrastructure.repository.FavoritoEntityRepository;
import br.will.msFavorito.infrastructure.service.FavoritoService;
import br.will.msFavorito.usecase.DeletarFavoritoUseCase;
import br.will.msFavorito.usecase.SalvarFavoritoUseCase;
import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/favorito")
public class FavoritoController {
    public FavoritoMapper favoritoMapper;
    public SalvarFavoritoUseCase salvarFavoritoUseCase;
    public DeletarFavoritoUseCase deletarFavoritoUseCase;
    public FavoritoEntityRepository favoritoEntityRepository;
    public FavoritoService favoritoService;

    public FavoritoController(FavoritoMapper favoritoMapper, SalvarFavoritoUseCase salvarFavoritoUseCase,
            DeletarFavoritoUseCase deletarFavoritoUseCase,FavoritoEntityRepository favoritoEntityRepository,
            FavoritoService favoritoService) {
        this.favoritoMapper = favoritoMapper;
        this.salvarFavoritoUseCase = salvarFavoritoUseCase;
        this.deletarFavoritoUseCase = deletarFavoritoUseCase;
        this.favoritoEntityRepository = favoritoEntityRepository;
        this.favoritoService = favoritoService;
    }


    @PostMapping("/{id}")
    @Transactional
    public BaseResponse<String> adicionarFavorito( @RequestBody FavoritoData data){
        ResponseEntity<FavoritoEntity> favorito =  favoritoService.AdicionarFavorito(data);
        return BaseResponse.<String>builder().success(true).message("favorito creado").build();        
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarFavorito(@PathVariable Long id, FavoritoData favoritoData){
        if (id != null ) {
            favoritoEntityRepository.deleteById(id);
        }
    }

    
}
