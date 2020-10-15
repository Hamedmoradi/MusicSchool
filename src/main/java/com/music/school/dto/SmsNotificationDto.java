package com.music.school.dto;

import com.music.school.domain.Notification;
import com.music.school.domain.SmsNotification;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name = "smsNotification")
public class SmsNotificationDto implements Serializable {
    private Integer id;
    private String context;
    private String phoneNumber;
    private String messageType;
    private Integer status;
    private Date createdOn;


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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public static Optional<SmsNotificationDto >smsNotificationToSmsNotificationDto(SmsNotification smsNotification){
        if(smsNotification !=null ){
            SmsNotificationDto smsNotificationDto = new SmsNotificationDto();
            smsNotificationDto.setId(smsNotification.getId());
            smsNotificationDto.setContext(smsNotification.getContext());
            smsNotificationDto.setCreatedOn(smsNotification.getCreatedOn());
            smsNotificationDto.setPhoneNumber(smsNotification.getPhoneNumber());
            smsNotificationDto.setStatus(smsNotification.getStatus());
            smsNotificationDto.setMessageType(smsNotification.getMessageType());
            return Optional.of(smsNotificationDto);
        }else{
            return Optional.empty();
        }
    }

    public static List<Optional<SmsNotificationDto>> smsNotificationToSmsNotificationDto(List<Notification> smsNotifications) {
        if (null != smsNotifications && smsNotifications.size() > 0) {
            List<Optional<SmsNotificationDto>> smsNotificationDtoList = new ArrayList<>(smsNotifications.size());
            for (Notification smsNotification : smsNotifications) {
                smsNotificationDtoList.add(smsNotificationToSmsNotificationDto((SmsNotification) smsNotification));
            }
            return smsNotificationDtoList;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}

