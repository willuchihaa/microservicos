package br.will.msFavorito.application.usecaseimpl;
import br.will.msFavorito.application.gateway.CreateFavoritoGateway;
import br.will.msFavorito.core.domain.Favorito;
import br.will.msFavorito.infrastructure.repository.FavoritoEntityRepository;
import br.will.msFavorito.usecase.DeletarFavoritoUseCase;
import br.will.msFavorito.usecase.ExistByIdUseCase;

public class DeletarFavoritoUseCaseImpl implements DeletarFavoritoUseCase {
    private CreateFavoritoGateway createFavoritoGateway;
    private FavoritoEntityRepository favoritoEntityRepository;
    private ExistByIdUseCase existByIdUseCase;

     public DeletarFavoritoUseCaseImpl(CreateFavoritoGateway createFavoritoGateway,
            FavoritoEntityRepository favoritoEntityRepository, ExistByIdUseCase existByIdUseCase) {
        this.createFavoritoGateway = createFavoritoGateway;
        this.favoritoEntityRepository = favoritoEntityRepository;
        this.existByIdUseCase = existByIdUseCase;
    }

    @Override
     public void deleteById(Favorito favorito) {
         if (this.existByIdUseCase.existsById(favorito.getId())) {
             this.createFavoritoGateway.deletar(favorito);
         }else
         System.out.println("item nao incotrado");
     }



    }
