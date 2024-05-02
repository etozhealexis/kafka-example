package com.example.consumer.service;

import com.example.consumer.model.MetricsData;
import com.example.consumer.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessagingService {
    @Transactional
    @KafkaListener(
            topics = "${topic.send-data}",
            groupId = "${spring.kafka.consumer.group-id}",
            properties = {
                    "spring.json.value.default.type=com.example.consumer.model.MetricsData"
            }
    )
    public void createOrder(MetricsData metricsData) {
        log.info(String.format(Constant.KAFKA_RECEIVED_MESSAGE, metricsData.getUuid()));
        log.info(metricsData.toString());
    }
}
