package com.mylearning.clients.notification;

public record NotificationRequest(
        Integer toStudentId,
        String toCustomerName,
        String message
        ) {

}
