package com.micro.lcl.sleb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.micro.lcl.sleb")
public class LclSlebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LclSlebApplication.class, args);
    }

}
