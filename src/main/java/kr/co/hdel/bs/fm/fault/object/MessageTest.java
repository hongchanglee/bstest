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

package kr.co.hdel.bs.fm.fault.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Hong-Chang Lee
 */
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MessageTest
{
    private String id;
    private String value;
}
