package com.mylearning.notification;

import com.mylearning.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    public void send(NotificationRequest request);
}
