package com.music.school.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "scheduler")
@EntityListeners(AuditingEntityListener.class)
public class Scheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "request_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date requestDate;

    @Column(name = "due_Date")
    @LastModifiedDate
    private Date dueDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "Service_Code")
    private Integer serviceCode;

    @Column(name = "Service_Name")
    private String serviceName;

    @Column(name = "busy")
    private boolean busy;

    @JoinColumn(name = "notification_id")
    @ManyToOne
    private Notification notificationId;




    public Scheduler() {
    }


    public Scheduler(Date requestDate, Date dueDate, Integer status, Integer serviceCode, String serviceName,
                     Boolean busy) {
        this.requestDate = requestDate;
        this.dueDate = dueDate;
        this.status = status;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.busy = busy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Integer serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Notification getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Notification notificationId) {
        this.notificationId = notificationId;
    }
}
