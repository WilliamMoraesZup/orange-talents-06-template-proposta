package com.zup.william.proposta.proposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
//@EnableWebSecurity(debug = true)
public class PropostaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropostaApplication.class, args);
    }

}
