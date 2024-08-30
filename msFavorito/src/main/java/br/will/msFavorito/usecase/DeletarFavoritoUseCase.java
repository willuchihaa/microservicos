package br.will.msFavorito.usecase;

import br.will.msFavorito.core.domain.Favorito;

public interface DeletarFavoritoUseCase {
    void deleteById(Favorito favorito);
}
