package br.will.msFavorito.usecase;

import br.will.msFavorito.core.domain.Favorito;

public interface SalvarFavoritoUseCase {
     void saveFavorito(Favorito favorito, String nome);
}
