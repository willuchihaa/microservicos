package br.will.msUsuario.infrastructure.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaUsuarioService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaUsuarioService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
