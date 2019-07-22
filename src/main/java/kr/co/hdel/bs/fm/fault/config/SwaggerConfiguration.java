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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Before Service Fault Monitoring Server.
 * 웹서비스 컨트롤러 테스트 UI 제공 Swagger 설정 클래스
 * 
 * @author Hong-Chang Lee
 * @version 0.0.1-SNAPSHOT
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
    @Bean
    public Docket api()
    {
        ApiInfoBuilder builder = new ApiInfoBuilder()
                .title("BS Fault Monitoring Server - Fualt Control Microservice Api Doc")
                .description("Swagger Test")
                .version("0.0.1-SNAPSHOT")
                .contact(new Contact("Hong-Chang Lee", "hdel.co.kr", "hongchang.lee@hdel.co.kr"));
        
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("kr.co.hdel.bs.fm.fault.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(builder.build());
    }
}
