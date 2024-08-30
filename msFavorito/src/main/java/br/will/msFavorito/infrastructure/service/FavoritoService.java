package br.will.msFavorito.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.will.msFavorito.core.domain.Favorito;
import br.will.msFavorito.infrastructure.dto.FavoritoData;
import br.will.msFavorito.infrastructure.entity.FavoritoEntity;
import br.will.msFavorito.infrastructure.repository.FavoritoEntityRepository;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class FavoritoService {
   @Autowired
   private FavoritoEntityRepository favoritoEntityRepository;
   
   
   public FavoritoData getFavorito(@PathVariable Long id, HttpServletResponse res){
    if(id != null){
        FavoritoEntity c = favoritoEntityRepository.getReferenceById(id);
        FavoritoData cd = new FavoritoData(c);
        return cd;
    }
    res.setStatus(204);
    return null;
}

    public ResponseEntity<FavoritoEntity> AdicionarFavorito(@RequestBody FavoritoData data) {
        FavoritoEntity c = new FavoritoEntity(data);
        favoritoEntityRepository.save(c);
        return null;
        
    }
    public void RemoverFavorito(@PathVariable Long id){
        if(id != null){
            favoritoEntityRepository.deleteById(id);
        }
    }
   }

