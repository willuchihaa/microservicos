package br.will.msCarrinho.infrastructure.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.will.msCarrinho.core.domain.Carrinho;
import br.will.msCarrinho.infrastructure.dto.CarrinhoData;
import br.will.msCarrinho.infrastructure.entity.CarrinhoEntity;
import br.will.msCarrinho.infrastructure.repository.CarrinhoEntityRepository;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoEntityRepository carrinhoEntityRepository;
    

public CarrinhoData PegarOItem(@PathVariable Long id, HttpServletResponse res) {
        if(id != null /*&& itemRepository.existsById(id)*/){
            CarrinhoEntity d = carrinhoEntityRepository.getReferenceById(id);
            CarrinhoData de = new CarrinhoData(d);
            return de;
        }
        res.setStatus(204);
        return null;
    }

    public ResponseEntity<CarrinhoEntity> salvaItem(Long id, @RequestBody CarrinhoData data) {
        //tem que checar se existe no repo de item, mas ne
        
            CarrinhoEntity c = new CarrinhoEntity(data);
            carrinhoEntityRepository.save(c);
            
        /*Carrinho carrinhoCalcularTotal = new Carrinho();// pela logica eu criei um novo
            carrinhoCalcularTotal.calcularTotal(null);
            System.out.println(carrinhoCalcularTotal);   */
        return null;
    }
    public void deletarItem(@PathVariable Long id){
        if(id != null){
            carrinhoEntityRepository.deleteById(id);
        }
    }
    public ResponseEntity<CarrinhoEntity> atualizarItem(@PathVariable Long id, @RequestBody CarrinhoData data){
        if(id != null){
            CarrinhoEntity c = carrinhoEntityRepository.getReferenceById(id);
            c.updatee(data);
        }
        return null;
    }
    

    
}
