package com.music.school.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "notification", discriminatorType = DiscriminatorType.STRING)
@EntityListeners(AuditingEntityListener.class)

public abstract class Notification{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn(name = "notification_id")
    private Integer id;

    @Column(name = "context")
    private String context;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "status")
    protected Integer status;

    @Column(name = "messageType")
    protected String messageType;


    @JoinColumn(name = "notification_message_type_id")
    @ManyToOne
    private NotificationMessageType notificationMessageTypeId;


    public Notification() {
    }

    public Notification(String context, Date createdOn, Integer status, String messageType, NotificationMessageType notificationMessageTypeId) {
        this.context = context;
        this.createdOn = createdOn;
        this.status = status;
        this.messageType = messageType;
        this.notificationMessageTypeId = notificationMessageTypeId;
    }

    public Notification(String context, Date createdOn, int status, String messageType) {
        this.context = context;
        this.createdOn = createdOn;
        this.status = status;
        this.messageType = messageType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public NotificationMessageType getNotificationMessageTypeId() {
        return notificationMessageTypeId;
    }

    public void setNotificationMessageTypeId(NotificationMessageType notificationMessageTypeId) {
        this.notificationMessageTypeId = notificationMessageTypeId;
    }

}
