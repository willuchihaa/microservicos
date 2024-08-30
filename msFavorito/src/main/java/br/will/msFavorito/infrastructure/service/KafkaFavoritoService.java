package br.will.msFavorito.infrastructure.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaFavoritoService {
    
    @KafkaListener(topics = "Microservice_Favorito", groupId = "will-group")
    public void consumirMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
        // Aqui você pode processar a mensagem conforme necessário
    }
}
