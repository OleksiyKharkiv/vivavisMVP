package com.example.vivavis;

import org.springframework.boot.SpringApplication;

public class TestDemo1Application {

    public static void main(String[] args) {
        SpringApplication.from(VivavisApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
