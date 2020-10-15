package com.music.school.service.serviceImpl;

import com.music.school.domain.*;
import com.music.school.dto.ClientDto;
import com.music.school.enums.AvailableService;
import com.music.school.enums.MessageRegistration;
import com.music.school.enums.Status;
import com.music.school.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class NotificationServiceImpl implements NotificationService {

private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);


@Autowired
private EmailService emailService;
@Autowired
private SmsService smsService;
@Autowired
private NotificationMessageTypeService notificationMessageTypeService;
@Autowired
private SchedulerService schedulerService;

public void createNotificationMessage(ClientDto clientDto, Student student) {
	String[] title = clientDto.getMessageTitleService();
	ArrayList<Notification> notificationList = new ArrayList<>();
	Notification emailMessagesType = null;
	Notification smsMessagesType = null;
	
	for (String titles : title) {
		
		if (clientDto.isEmailChecked()) {
			
			emailMessagesType = beforeCreateNotificationMessage(clientDto, MessageRegistration.EMAIL.getServiceCode(), titles);
		}
		if (clientDto.isSmsChecked()) {
			
			smsMessagesType = beforeCreateNotificationMessage(clientDto, MessageRegistration.SMS.getServiceCode(), titles);
		}
	}
	notificationList.add(emailMessagesType);
	notificationList.add(smsMessagesType);
	createNotificationMessageType(clientDto, student, notificationList);
	
	
}

private void createNotificationMessageType(ClientDto clientDto, Student student, ArrayList<Notification> notifications) {
	for (Notification notification : notifications) {
		
		if (notification instanceof EmailNotification) {
			
			processSavingNotificationMessageType(notification, MessageRegistration.EMAIL.getServiceCode(), clientDto, student);
			
		} else if (notification instanceof SmsNotification) {
			
			processSavingNotificationMessageType(notification, MessageRegistration.SMS.getServiceCode(), clientDto, student);
		}
	}
}

private void processSavingNotificationMessageType(Notification messagesTypes, int code, ClientDto clientDto, Student student) {
	NotificationMessageType notificationMessageType =
			saveMessageType(clientDto, student, MessageRegistration.setNotificationService(code));
	setNotificationMessageTypeId(messagesTypes, notificationMessageType);
}

private Notification beforeCreateNotificationMessage(ClientDto clientDto, int serviceCode, String title) {
	return prepareService(title, getNotificationFactory(clientDto, serviceCode));
}

private Notification getNotificationFactory(ClientDto clientDto, int serviceCode) {
	
	Notification notification = null;
	
	if (serviceCode == 1000) {
		notification = new EmailNotification(clientDto.getEmailAddress(), Status.SUCCESS.getResultCode());
	} else if (serviceCode == 2000) {
		notification = new SmsNotification(clientDto.getCellphone(), Status.SUCCESS.getResultCode());
	}
	return notification;
}


private Notification prepareService(String title, Notification notification) {
	Notification messagesTypes = initializeMessagesTypes(notification, title);
	afterSetMessages(messagesTypes);
	return messagesTypes;
}

private Notification initializeMessagesTypes(Notification notification, String title) {
	switch (title) {
		case "accounthistory":
			createContext(notification, title, AvailableService.ACCOUNT_HISTORY);
			break;
		case "classInformation":
			createContext(notification, title, AvailableService.CLASS_INFORMATION);
			break;
		case "accountstatement":
			createContext(notification, title, AvailableService.ACCOUNT_STATEMENT);
			break;
		
	}
	
	notification.setCreatedOn(new Date());
	return notification;
}

private void afterSetMessages(Notification notificationChild) {
	
	if (notificationChild instanceof EmailNotification) {
		emailService.save((EmailNotification) notificationChild);
		schedulerService.saveSchedulerService(notificationChild, MessageRegistration.EMAIL, this);
	} else if (notificationChild instanceof SmsNotification) {
		smsService.save((SmsNotification) notificationChild);
		schedulerService.saveSchedulerService(notificationChild, MessageRegistration.SMS, this);
		
	}
	
}

private NotificationMessageType saveMessageType(ClientDto clientDto, Student student, MessageRegistration messageRegistration) {
	NotificationMessageType messageType = new NotificationMessageType();
	student=ClientDto.clientDtoToStudent(clientDto);
	messageType.setStudentId(student);
	messageType.setActive(true);
	messageType.setMessageTitle(clientDto.getMessageTitleService());
	messageType.setType(messageRegistration.getServiceName());
	notificationMessageTypeService.save(messageType);
	return messageType;
}

private void setNotificationMessageTypeId(Notification messagesTypes, NotificationMessageType notificationMessageType) {
	messagesTypes.setNotificationMessageTypeId(notificationMessageType);
}




private void createContext(Notification notification, String titles, AvailableService availableService) {
	notification.setContext(availableService.contextValue(titles));
	notification.setMessageType(titles);
}
}



