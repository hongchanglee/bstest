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

package kr.co.hdel.bs.fm.fault.model;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import kr.co.hdel.bs.fm.fault.config.RemoteConfigAccessor;
import kr.co.hdel.bs.fm.fault.discovery.MicroserviceFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Before Service Fault Monitoring Server.
 * 실시간 모니터링 마이크로서비스 메인 비즈니스 로직 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class FaultControlService
{
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private EurekaClient eurekaclient;
        
    @Autowired
    private Environment environment;
    
    @Autowired
    private MicroserviceFinder microserviceFinder;
    
    @Autowired
    private RemoteConfigAccessor remoteConfigAccessor;

    
    public String getCurrentElConnections()
    {
        String applicationName = remoteConfigAccessor.getLeafServices().get("mon");
        String urlOfCurrentConnections = microserviceFinder.getUrlOfCurrentConnections(applicationName);
        
        ResponseEntity<String> exchange = restTemplate.exchange(urlOfCurrentConnections, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        
        return exchange.getBody();
    }
}
