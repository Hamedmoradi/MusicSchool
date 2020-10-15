package com.music.school.enums;

public enum MessageRegistration {
    EMAIL("email", 1000),
    SMS("sms", 2000);

    private String serviceName;
    private int serviceCode;

    MessageRegistration(final String serviceName, final int serviceCode) {
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public static MessageRegistration setNotificationService(int code) {
        MessageRegistration messageRegistration = null;
        if (code == 1000) {
            messageRegistration = MessageRegistration.EMAIL;
        } else if (code == 2000) {
            messageRegistration = MessageRegistration.SMS;
        }
        return messageRegistration;
    }


}
