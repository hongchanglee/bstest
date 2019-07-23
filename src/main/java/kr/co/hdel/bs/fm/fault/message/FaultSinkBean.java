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

import kr.co.hdel.bs.fm.message.object.MessageTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Before Service Fault Monitoring Server.
 * 실시간 모니터링 마이크로서비스 메시징 소비자 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@Component
@Slf4j
public class FaultSinkBean
{
    private Sink sink;
    
    @Autowired
    public FaultSinkBean(Sink sink)
    {
        this.sink = sink;
    }
    
    @StreamListener(Sink.INPUT)
    public void getMessageValue(@Payload MessageTest test)
    {
        log.info("Received a value {} for Id {}", test.toString(), test.getId());
    } 
}
