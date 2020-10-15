package com.music.school.scheduler.schedulerImpl;

import com.music.school.domain.Student;
import com.music.school.dto.NotificationMessageTypeDto;
import com.music.school.enums.AvailableService;
import com.music.school.enums.MessageRegistration;
import com.music.school.providers.AbstractProviderService;
import com.music.school.providers.EmailProvider;
import com.music.school.providers.SmsProvider;
import com.music.school.scheduler.ScheduledTasks;
import com.music.school.service.StudentService;
import com.music.school.service.EmailService;
import com.music.school.service.NotificationMessageTypeService;
import com.music.school.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

@Component
public class ScheduledTasksImpl implements ScheduledTasks {

private static final Logger logger = LoggerFactory.getLogger(ScheduledTasksImpl.class);

@Autowired
private NotificationMessageTypeService notificationMessageTypeService;

@Qualifier("smsProvider")
@Autowired
private AbstractProviderService abstractSmsProviderService;
@Qualifier("emailProvider")
@Autowired
AbstractProviderService abstractEmailProviderService;

@Autowired
private StudentService studentService;

//@Autowired
//private EmailService emailService;
//
//@Autowired
//private SmsService smsService;

@Scheduled(fixedRate = 60000)
public void sendNotification() {
	logger.debug("----------sending Notification Start-----------");
	for (Optional<NotificationMessageTypeDto> notificationMessageType : notificationMessageTypeService.getAll()) {
		if (notificationMessageType.isPresent()) {
			String type = notificationMessageType.get().getType();
			String[] messageTitles = notificationMessageType.get().getMessageTitle();
			beforeRunningScheduler(type, messageTitles);
			logger.debug("----------show result----------");
		}
	}
}

public void beforeRunningScheduler(String type, String[] titles) {
	for (String title : titles) {
		if (type.equals(MessageRegistration.EMAIL.getServiceName())) {
			
			EmailProvider emailProvider;
			emailProvider = (EmailProvider) abstractEmailProviderService;
			doJob(type, MessageRegistration.EMAIL, "FOR EMAIL SERVICE:", title, emailProvider);
			
			
		} else if (type.equals(MessageRegistration.SMS.getServiceName())) {
			
			SmsProvider smsProvider;
			smsProvider = (SmsProvider) abstractSmsProviderService;
			doJob(type, MessageRegistration.SMS, "FOR SMS SERVICE:", title, smsProvider);
		}
	}
	
}

public void doJob(String submissionType, MessageRegistration messageRegistration,
                  String statement, String bankService, AbstractProviderService provider) {
	if (bankService.equals(AvailableService.CLASS_INFORMATION.getBankService()) &&
			    submissionType.equals(messageRegistration.getServiceName())) {
		sendToServiceProvider(messageRegistration, AvailableService.CLASS_INFORMATION, statement, provider);
	} else if (bankService.equals(AvailableService.ACCOUNT_STATEMENT.getBankService()) &&
			           submissionType.equals(messageRegistration.getServiceName())) {
		sendToServiceProvider(messageRegistration, AvailableService.ACCOUNT_STATEMENT, statement, provider);
	} else if (bankService.equals(AvailableService.ACCOUNT_HISTORY.getBankService()) &&
			           submissionType.equals(messageRegistration.getServiceName())) {
		sendToServiceProvider(messageRegistration, AvailableService.ACCOUNT_HISTORY, statement, provider);
	}
}

private void sendToServiceProvider(MessageRegistration messageRegistration, AvailableService availableService, String statement, AbstractProviderService provider) {
	List<Optional<NotificationMessageTypeDto>> all = notificationMessageTypeService.getAll();
	for (Optional<NotificationMessageTypeDto> notificationMessageTypeDto : all) {
		Student student = notificationMessageTypeDto.get().getStudentId();
		Optional<Student> studentByNationalCode = studentService.getStudentByNationalCode(student);
		
		if (student.getNationalCode().equals(studentByNationalCode.get().getNationalCode()) && messageRegistration.equals(MessageRegistration.EMAIL)) {
			String resultFromDB = notificationMessageTypeService.getEmailBystudentId(notificationMessageTypeDto);
			runProvider(messageRegistration, availableService, statement, provider, student, resultFromDB);
		}
		if (student.getNationalCode().equals(studentByNationalCode.get().getNationalCode()) && messageRegistration.equals(MessageRegistration.SMS)) {
			String resultFromDB = notificationMessageTypeService.getSmsByStudentId(notificationMessageTypeDto);
			runProvider(messageRegistration, availableService, statement, provider, student, resultFromDB);
		}
	}
}

private void runProvider(MessageRegistration messageRegistration, AvailableService availableService, String statement,
                         AbstractProviderService provider, Student student, String fromDB) {
	provider.sendSimpleMessage(fromDB, messageRegistration.getServiceName(), availableService.getContext());
	
	logger.info(statement + availableService.getContext() + student);
	
	//todo after send to provider if there is no Exception & send was successfully SET Status for scheduler SUCCESS else another Statuses ...
}

}
