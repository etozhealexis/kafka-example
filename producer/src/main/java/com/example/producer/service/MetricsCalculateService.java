package com.example.producer.service;

import com.example.producer.model.MetricsData;
import com.example.producer.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

@RequiredArgsConstructor
@Service
public class MetricsCalculateService {
    private final MemoryMXBean memoryMXBean;
    private final ThreadMXBean threadMXBean;

    public MetricsData calculateMetrics() {
        return MetricsData.builder()
                .space(getSpaceMetrics())
                .memory(getMemoryMetrics())
                .cpu(getCPUMetrics())
                .build();
    }

    private String getSpaceMetrics() {
        File root = new File(Constant.ROOT_PATH);
        double totalSpace = (double) root.getTotalSpace() / Constant.FROM_BITS_TO_GB;
        double freeSpace = (double) root.getFreeSpace() / Constant.FROM_BITS_TO_GB;
        double usableSpace = (double) root.getUsableSpace() / Constant.FROM_BITS_TO_GB;
        return String.format(Constant.SPACE_METRICS_MESSAGE, totalSpace, freeSpace, usableSpace);
    }

    private String getMemoryMetrics() {
        double initialHeapMemory = (double) memoryMXBean.getHeapMemoryUsage().getInit() / Constant.FROM_BITS_TO_GB;
        double usedHeapMemory = (double) memoryMXBean.getHeapMemoryUsage().getUsed() / Constant.FROM_BITS_TO_GB;
        double maxHeapMemory = (double) memoryMXBean.getHeapMemoryUsage().getMax() / Constant.FROM_BITS_TO_GB;
        double committedMemory = (double) memoryMXBean.getHeapMemoryUsage().getCommitted() / Constant.FROM_BITS_TO_GB;
        return String.format(Constant.MEMORY_METRICS_MESSAGE, initialHeapMemory, usedHeapMemory, maxHeapMemory, committedMemory);
    }

    private String getCPUMetrics() {
        StringBuilder cpuMetricsBuilder = new StringBuilder();
        for (Long threadID : threadMXBean.getAllThreadIds()) {
            ThreadInfo info = threadMXBean.getThreadInfo(threadID);
            cpuMetricsBuilder.append(Constant.THREAD_NAME).append(info.getThreadName()).append(Constant.LINE_BREAK)
                    .append(Constant.THREAD_STATE).append(info.getThreadState()).append(Constant.LINE_BREAK)
                    .append(String.format(Constant.CPU_TIME, threadMXBean.getThreadCpuTime(threadID)))
                    .append(Constant.LINE_BREAK).append(Constant.LINE_BREAK);
        }
        return cpuMetricsBuilder.toString();
    }
}
