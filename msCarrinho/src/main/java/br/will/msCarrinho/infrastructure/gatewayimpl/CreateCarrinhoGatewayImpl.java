package br.will.msCarrinho.infrastructure.gatewayimpl;

import br.will.msCarrinho.application.gateway.CreateCarrinhoGateway;
import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.infrastructure.entity.CarrinhoEntity;
import br.will.msCarrinho.infrastructure.mapper.CarrinhoMapper;
import br.will.msCarrinho.infrastructure.repository.CarrinhoEntityRepository;

public class CreateCarrinhoGatewayImpl implements CreateCarrinhoGateway {
    
    private CarrinhoEntityRepository  carrinhoEntityRepository;
    private CarrinhoMapper carrinhoMapper;

    public CreateCarrinhoGatewayImpl(CarrinhoEntityRepository carrinhoEntityRepository, CarrinhoMapper carrinhoMapper) {
        this.carrinhoEntityRepository = carrinhoEntityRepository;
        this.carrinhoMapper = carrinhoMapper;

    }
    @Override
    public Carrinho create(Carrinho carrinho) {
        CarrinhoEntity carrinhoSaved = carrinhoEntityRepository.save(carrinhoMapper.toCarrinhoEntity(carrinho));
        return null;
    }
    @Override
    public Carrinho delete(Carrinho carrinho) {
        return carrinho;
        //CarrinhoEntity carrinhoDeleted = carrinhoEntityRepository.deleteById(null);
    }
    @Override
    public Carrinho Atualizar(Carrinho carrinho) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Atualizar'");
    }

    
}
