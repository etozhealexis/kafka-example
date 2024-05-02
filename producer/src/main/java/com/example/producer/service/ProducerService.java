package com.example.producer.service;

import com.example.producer.model.MetricsData;
import com.example.producer.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProducerService {
    private final MetricsCalculateService metricsCalculateService;
    private final KafkaMessagingService kafkaMessagingService;

    public void sendMetrics(String uuid) {
        MetricsData metricsData = metricsCalculateService.calculateMetrics();
        metricsData.setUuid(uuid);
        log.info(String.format(Constant.SENDING_METRICS_MANUALLY_WITH_ID_MESSAGE, uuid));
        kafkaMessagingService.sendMetricsData(metricsData);
    }

    @Scheduled(fixedRate = 10000)
    public void sendMetrics() {
        MetricsData metricsData = metricsCalculateService.calculateMetrics();
        metricsData.setUuid(UUID.randomUUID() + Constant.SCHEDULED_UUID);
        log.info(String.format(Constant.SENDING_METRICS_SCHEDULED_MESSAGE, metricsData.getUuid()));
        kafkaMessagingService.sendMetricsData(metricsData);
    }
}
