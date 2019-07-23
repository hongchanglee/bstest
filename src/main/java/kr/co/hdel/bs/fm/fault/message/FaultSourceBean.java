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

package kr.co.hdel.bs.fm.fault.message;

import kr.co.hdel.bs.fm.fault.object.MessageTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Before Service Fault Monitoring Server.
 * 실시간 모니터링 마이크로서비스 메시징 생산자 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@Component
@Slf4j
public class FaultSourceBean
{
    private Source source;
    
    @Autowired
    public FaultSourceBean(Source source)
    {
        this.source = source;
    }
    
    public void publishTestValue(String id, String value)
    {
        log.info("Sending kafka message {} for Id: {}", value, id);
        
        MessageTest test = new MessageTest(id, value);
        
        source.output().send(MessageBuilder.withPayload(test).build());
    }
    
}
