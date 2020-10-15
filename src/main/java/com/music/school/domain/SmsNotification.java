package com.music.school.domain;

import javax.persistence.*;
import java.util.Date;



@Entity
@DiscriminatorValue("sms_notification")
public class SmsNotification extends Notification {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "phone_number",nullable = true)
    private String phoneNumber;


    public SmsNotification(){};



    public SmsNotification(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public SmsNotification(String phoneNumber, Integer status) {
        this.phoneNumber=phoneNumber;
        this.status=status;
    }

    public SmsNotification(String context, Date createdOn, int status, String messageType, String phoneNumber) {
        super(context, createdOn, status, messageType);
        this.phoneNumber = phoneNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
