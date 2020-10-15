package com.music.school.providers;


import org.springframework.context.annotation.Scope;

import javax.mail.MessagingException;
@Scope("prototype")
public abstract class AbstractProviderService {
    public String to;
    public String subject;
    public String text;

    public AbstractProviderService(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    protected AbstractProviderService() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void sendSimpleMessage(String to, String subject, String text);

    public abstract void sendMessageWithAttachment
            (String to, String subject, String text, String pathToAttachment) throws MessagingException;

}
