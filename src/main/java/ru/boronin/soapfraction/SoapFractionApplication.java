package ru.boronin.soapfraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
public class SoapFractionApplication {
        public static void main(String[] args) {
            SpringApplication.run(SoapFractionApplication.class, args);
        }
    }


