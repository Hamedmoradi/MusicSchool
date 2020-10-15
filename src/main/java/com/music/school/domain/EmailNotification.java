package com.music.school.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@DiscriminatorValue("email_notification")
public class EmailNotification extends Notification {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "email_address", nullable = true)
    private String emailAddress;

    public EmailNotification() {
    }

    public EmailNotification(Integer id, String emailAddress) {
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public EmailNotification(String context, Date createdOn, int status, String messageType, String emailAddress) {
        super(context, createdOn, status, messageType);
        this.emailAddress = emailAddress;
    }

    public EmailNotification(String emailAddress, int status) {
        this.emailAddress = emailAddress;
        this.status = status;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
