package br.will.msFavorito.application.gateway;

import br.will.msFavorito.core.domain.Favorito;

public interface CreateFavoritoGateway {
    Favorito salvar(Favorito favorito);

    Favorito deletar(Favorito favorito);
}
