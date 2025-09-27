package com.example;

import com.example.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CalculatorListener {

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate; // Para enviar resposta

    @KafkaListener(topics = "calc-requests", groupId = "calculator-group")
    public void processCalculationRequest(CalculationRequest request) {

        // Compute the result using CalculationService
        var result = calculationService.calculate(request);

        // Create response object
        CalculationResponse response = new CalculationResponse(result, request.getRequestId());

        // Send the response to the "calc-responses" topic
        kafkaTemplate.send("calc-responses", request.getRequestId(), response);
    }
}
