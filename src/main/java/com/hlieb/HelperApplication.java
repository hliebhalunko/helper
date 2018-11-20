package com.hlieb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaRepositories
@EnableAspectJAutoProxy
@SpringBootApplication
public class HelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelperApplication.class, args);
    }
}
