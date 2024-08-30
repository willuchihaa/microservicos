package br.will.msFavorito.application.usecaseimpl;

import br.will.msFavorito.application.gateway.CreateFavoritoGateway;
import br.will.msFavorito.core.domain.Favorito;
import br.will.msFavorito.usecase.ExistByIdUseCase;
import br.will.msFavorito.usecase.SalvarFavoritoUseCase;

public class SalvarFavoritoUseCaseImpl implements SalvarFavoritoUseCase{
    private CreateFavoritoGateway createFavoritoGateway;
    private ExistByIdUseCase existByIdUseCase;


    public SalvarFavoritoUseCaseImpl(CreateFavoritoGateway createFavoritoGateway,ExistByIdUseCase existByIdUseCase) {
        this.createFavoritoGateway = createFavoritoGateway;
        this.existByIdUseCase = existByIdUseCase;
    }
    @Override
    public void saveFavorito(Favorito favorito, String nome) {
        if (existByIdUseCase.existsById(favorito.getId())) {
            Favorito favoritoSaved = this.createFavoritoGateway.salvar(new Favorito(null, nome));
            System.out.println("Favorito adicionado com sucesso");

        }

    }

    
}
