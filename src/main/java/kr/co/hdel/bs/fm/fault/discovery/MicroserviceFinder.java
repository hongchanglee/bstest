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

package kr.co.hdel.bs.fm.fault.discovery;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Before Service Fault Monitoring Server.
 * 실시간 모니터링 마이크로서비스의 서비스 파인더 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class MicroserviceFinder
{
   @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private EurekaClient eurekaclient;
        
    @Autowired
    private Environment environment;

    
    public String getUrlOfCurrentConnections(String applicationName)
    {
        StringBuilder result = new StringBuilder();
        
        result.append("http://");
        result.append(applicationName);
        result.append("/monitor/info/el/connections");
        
        return result.toString();
    }
    
}
