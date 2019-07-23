/*
 *  Copyright (C) 2020 HYUNDAIELEVATOR Co.,LTD. ALL RIGHT RESERVED.
 *  
 *  License Ver : 1.0
 *  Company     : Hyundai Elevator
 *  Department  : R&D Center
 *  Developer   : Hong-Chang Lee
 *  E-mail      : hongchang.lee@hdel.co.kr
 * 
 *  Application : Before Service Fault Monitoring Server
 *  Dev Part    : Phase1 B2
 *  Dev Year    : 2019
 */

package kr.co.hdel.bs.fm.fault;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Before Service Fault Monitoring Server.
 * 실시간 모니터링 마이크로서비스 부트스트랩 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Processor.class)
@Slf4j
public class FaultControlServiceBootstrap
{
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
    
    

    public static void main(String[] args) 
    {
        SpringApplication.run(FaultControlServiceBootstrap.class, args);
    }
}