package com.example.controller;

import com.example.CalculationRequest;
import com.example.CalculationResponse;
import com.example.config.KafkaProducerTemplate;
import com.example.listener.ResponseListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class CalculatorRequestController {

    // Inject KafkaTemplate instance, this instance is what allows us to send messages through Kafka
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ResponseListener responseListener;

    @GetMapping("/sum")
    public ResponseEntity<CalculationResponse> sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {

        // Create object to send through Kafka
        String requestId = UUID.randomUUID().toString();
        CalculationRequest request = new CalculationRequest("sum", a,b,requestId);

        // Send the message to the topic "calc-request"
        kafkaTemplate.send("calc-requests", requestId, request);

        CalculationResponse response = responseListener.getResponse(requestId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/subtraction")
    public ResponseEntity<CalculationResponse> subtraction(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        String requestId = UUID.randomUUID().toString();
        CalculationRequest request = new CalculationRequest("subtract", a,b,requestId);

        kafkaTemplate.send("calc-requests", requestId, request);

        CalculationResponse response = responseListener.getResponse(requestId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/multiplication")
    public ResponseEntity<CalculationResponse> multiplication(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        String requestId = UUID.randomUUID().toString();
        CalculationRequest request = new CalculationRequest("multiply", a,b,requestId);

        kafkaTemplate.send("calc-requests", requestId, request);

        CalculationResponse response = responseListener.getResponse(requestId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/division")
    public ResponseEntity<CalculationResponse> division(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        String requestId = UUID.randomUUID().toString();
        CalculationRequest request = new CalculationRequest("divide", a,b,requestId);

        kafkaTemplate.send("calc-requests", requestId, request);

        CalculationResponse response = responseListener.getResponse(requestId);

        return ResponseEntity.ok(response);
    }
}
