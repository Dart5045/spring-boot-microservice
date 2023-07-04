package com.mylearning.clients.student;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "student",
        path = "api/v1/students"
)
public interface StudentClient {
}
