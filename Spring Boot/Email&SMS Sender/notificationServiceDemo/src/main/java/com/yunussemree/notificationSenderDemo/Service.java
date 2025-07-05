package com.yunussemree.notificationSenderDemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }


    @Value("${sms_account_sid}")
    private String accountSID;
    @Value("${sms_auth_token}")
    private String authToken;
    @Value("${sms_twilio_phone_number}")
    private String from;

    public void sendSMS (String to, String body) { //require Twilio account
        Twilio.init(accountSID, authToken);
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();
    }

}
