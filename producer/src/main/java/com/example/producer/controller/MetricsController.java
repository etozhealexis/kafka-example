package com.example.producer.controller;

import com.example.producer.service.ProducerService;
import com.example.producer.util.ApiEndpoint;
import com.example.producer.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiEndpoint.METRICS_API)
public class MetricsController {
    private final ProducerService producerService;

    @PostMapping(ApiEndpoint.SEND_METRICS)
    private void sendMetrics() {
        log.info(Constant.SENDING_METRICS_MANUALLY_MESSAGE);
        producerService.sendMetrics(UUID.randomUUID() + Constant.MANUAL_UUID);
    }
}
