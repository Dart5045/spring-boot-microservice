package com.mylearning.notification;

import com.mylearning.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void send(NotificationRequest request) {
        Notification notificaiton = Notification.builder()
                .toStudentId(request.toStudentId())
                .message(request.message())
                .sender("Bladimir")
                .sentAt(LocalDateTime.now())
                .build();
        //To do check if email valid
        notificationRepository.saveAndFlush(notificaiton);
    }
}
