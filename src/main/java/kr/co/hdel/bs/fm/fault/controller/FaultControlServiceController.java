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

package kr.co.hdel.bs.fm.fault.controller;

import kr.co.hdel.bs.fm.fault.config.RemoteConfigAccessor;
import kr.co.hdel.bs.fm.fault.model.FaultControlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Before Service Fault Monitoring Server.
 * 실시간 모니터링 마이크로서비스 메인 웹서비스 컨트롤러 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/fault")
@Slf4j
public class FaultControlServiceController
{
    @Autowired
    private FaultControlService faultControlService ;
    
    @Autowired
    private RemoteConfigAccessor remoteConfigAccessor;
    
    @Autowired
    private BuildProperties buildProperties;
    
    @GetMapping("/test")
    public String getTest()
    {
        return "Remote Config Data = " + remoteConfigAccessor.getTestvar();
    }
    
    @GetMapping("/info/build/{property}")
    public String getBuildInfo(@PathVariable String property)
    {
        String result;
        
        switch(property)
        {
            case "name" :
                result = buildProperties.getName();
                break;
            case "version" :
                result = buildProperties.getVersion();
                break;
            case "time" :
                result = buildProperties.getTime().toString();
                break;
            case "artifact" :
                result = buildProperties.getArtifact();
                break;
            case "group" :
                result = buildProperties.getGroup();
                break;
            default :
                result = buildProperties.getName();
                break;
        }
        
        return "Build Informations (" + property + ") : " + result;
    }
    
    @GetMapping("/info/el/connections")
    public String getCurrentElConnections()
    {
        log.debug("log test debug");
        log.info("log test info");
        return faultControlService.getCurrentElConnections();
    }
}
