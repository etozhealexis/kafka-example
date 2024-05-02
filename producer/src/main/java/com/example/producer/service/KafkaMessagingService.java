package com.example.producer.service;

import com.example.producer.model.MetricsData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaMessagingService {
    @Value("${topic.send-data}")
    private String sendClientTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMetricsData(MetricsData metricsData) {
        kafkaTemplate.send(sendClientTopic, metricsData);
    }
}
