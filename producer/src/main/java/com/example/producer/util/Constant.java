package com.example.producer.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public static final String SENDING_METRICS_MANUALLY_MESSAGE = "Sending metrics manually";
    public static final String SENDING_METRICS_MANUALLY_WITH_ID_MESSAGE = "Sending metrics manually. id=%s";
    public static final String SENDING_METRICS_SCHEDULED_MESSAGE = "Sending metrics scheduled. id=%s";
    public static final String SPACE_METRICS_MESSAGE = "Total space: %.2f GB\nFree space: %.2f GB\nUsable space: %.2f GB";
    public static final String MEMORY_METRICS_MESSAGE = "Initial memory: %.2f GB\nUsed heap memory: %.2f GB\nMax heap memory: %.2f GB\nCommitted memory: %.2f GB";
    public static final String MANUAL_UUID = "-manual";
    public static final String SCHEDULED_UUID = "-scheduled";
    public static final String THREAD_NAME = "Thread name: ";
    public static final String THREAD_STATE = "Thread State: ";
    public static final String CPU_TIME = "CPU time: %s ms";
    public static final String ROOT_PATH = "/";
    public static final int FROM_BITS_TO_GB = 1073741824;
    public static final String LINE_BREAK = "\n";
}
