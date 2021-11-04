package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args){

        System.out.println("Ich starte jetzt");
        System.err.println("Ich bin rot");
        SpringApplication.run(DemoApplication.class, args);



    }


}
