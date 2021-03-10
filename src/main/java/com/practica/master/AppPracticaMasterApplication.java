package com.practica.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EntityScan({"com.practica.master","com.prueba.commons.proyecto.entity"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AppPracticaMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppPracticaMasterApplication.class, args);
    }

}
