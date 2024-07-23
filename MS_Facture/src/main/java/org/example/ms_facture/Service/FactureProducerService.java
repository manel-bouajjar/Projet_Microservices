package org.example.ms_facture.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FactureProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public FactureProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("facture_topic", message);
    }
}
