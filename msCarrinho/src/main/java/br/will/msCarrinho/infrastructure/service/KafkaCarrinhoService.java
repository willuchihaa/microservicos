package br.will.msCarrinho.infrastructure.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaCarrinhoService {

    @KafkaListener(topics = "Microservice_Carrinho", groupId = "will-group")
    public void consumirMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
        // Aqui você pode processar a mensagem conforme necessário
    }
}
