package com.mylearning.student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(
        basePackages = "com.mylearning.clients"
)
@SpringBootApplication(
        scanBasePackages = {
                "com.mylearning.student",
                "com.mylearning.amqp"}
)
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}