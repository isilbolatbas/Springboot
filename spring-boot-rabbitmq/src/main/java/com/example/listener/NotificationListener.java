package com.example.listener;

import com.example.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service

public class NotificationListener {

    @RabbitListener(queues = "isil-bolatbas-queue")
    public void handleOnMessage(Notification notification){

        System.out.println("Mesaj alindi.");
        System.out.println(notification.toString());
    }
}
