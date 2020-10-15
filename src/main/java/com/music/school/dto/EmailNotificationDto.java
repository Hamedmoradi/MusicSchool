package com.music.school.dto;



import com.music.school.domain.EmailNotification;
import com.music.school.domain.Notification;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name = "emailNotification")
public class EmailNotificationDto implements Serializable {
    private Integer id;
    private String context;
    private Date createdOn;
    private String emailAddress;
    private Integer status;
    private String messageType;


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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public static Optional<EmailNotificationDto > emailNotificationToEmailNotificationDto(EmailNotification emailNotification){
        if(emailNotification !=null ){
            EmailNotificationDto emailNotificationDto = new EmailNotificationDto();
            emailNotificationDto.setId(emailNotification.getId());
            emailNotificationDto.setContext(emailNotification.getContext());
            emailNotificationDto.setCreatedOn(emailNotification.getCreatedOn());
            emailNotificationDto.setEmailAddress(emailNotification.getEmailAddress());
            emailNotificationDto.setStatus(emailNotification.getStatus());
            emailNotificationDto.setMessageType(emailNotification.getMessageType());
            return Optional.of(emailNotificationDto);
        }else{
            return Optional.empty();
        }
    }

    public static List<Optional<EmailNotificationDto>> emailNotificationToEmailNotificationDto(List<Notification> emailNotifications) {
        if (null != emailNotifications && emailNotifications.size() > 0) {
            List<Optional<EmailNotificationDto>> emailNotificationDtoList = new ArrayList<>(emailNotifications.size());
            for (Notification emailNotification : emailNotifications) {
                emailNotificationDtoList.add(emailNotificationToEmailNotificationDto((EmailNotification) emailNotification));
            }
            return emailNotificationDtoList;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
