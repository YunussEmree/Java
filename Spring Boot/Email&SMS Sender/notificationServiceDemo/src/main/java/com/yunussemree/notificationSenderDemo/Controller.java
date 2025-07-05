package com.yunussemree.notificationSenderDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/sendMail")
    public String sendSimpleEmail(){
        service.sendEmail("example@gmail.com","Subject","Content of the email");
        return "Mail Sent";
    }

    @GetMapping("/sendSMS")
    public String sendSMS(){
        service.sendSMS("+0000000000000","Content of the SMS");
        return "SMS Sent";
    }
}
