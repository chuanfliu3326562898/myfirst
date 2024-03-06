package com.jiangfengliu.config;

import lombok.Data;

import java.util.List;

@Data
public class MeteorClientProperty {
    private String code;
    private String token;
    private String serverHost;
    private Integer serverPort = 8000;
    private Integer smartServerPort = 8001;
    private Integer innerPort = 8100;
    private Integer adminPort = 8200;
    private Integer restPort;
    private Integer healthCheckUpperLimit = 3;
    private String healthCheckPeriod = "PT3s";
    private String dataFolder = "./data";
    private String messageFolder = "./message";
    private Integer blockSize = 1024 * 1024;
    private BinaryLogs binaryLogs = new BinaryLogs();
    private List<Server> servers;

    @Data
    public static class BinaryLogs {
        private boolean adminEnable = false;
        private boolean innerEnable = false;
        private boolean serverEnable = false;
    }

    @Data
    public static class Server{
        private String host;
        private Integer port;
    }
}