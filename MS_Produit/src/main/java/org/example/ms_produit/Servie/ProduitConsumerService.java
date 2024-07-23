package org.example.ms_produit.Servie;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProduitConsumerService {
    @KafkaListener(topics = "facture_topic", groupId = "produit-group")
    public void consume(String message) {
        try {
            System.out.println("Received message: " + message);
            // Process the message here
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }
}
