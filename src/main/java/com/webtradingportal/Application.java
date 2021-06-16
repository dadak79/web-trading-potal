package com.webtradingportal;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화 : createDate, modifiedDate 자동 저장 활용
@SpringBootApplication
public class Application {
        public static void main(String[] args){
            SpringApplication.run(Application.class, args);
        }
}
