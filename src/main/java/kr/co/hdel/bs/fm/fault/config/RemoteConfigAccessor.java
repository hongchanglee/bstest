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

package kr.co.hdel.bs.fm.fault.config;

import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * Before Service Fault Monitoring Server.
 * 원격의 스프링 클라우드 컨피그 서버의 설정 정보를 불러오는 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@Service
@ConfigurationProperties(prefix="fault-properties")
@RefreshScope
@Getter
public class RemoteConfigAccessor
{
    @Value("${testvar}")
    private String testvar;
    
    private Map<String, String> leafServices = new HashMap<>();
}
