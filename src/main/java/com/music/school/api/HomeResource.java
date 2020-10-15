package com.music.school.api;

import com.music.school.domain.EmailNotification;
import com.music.school.domain.SmsNotification;
import com.music.school.dto.SchedulerDto;
import com.music.school.dto.SmsNotificationDto;
import com.music.school.scheduler.ScheduledTasks;
import com.music.school.service.*;
import com.music.school.domain.Scheduler;
import com.music.school.dto.ClientDto;
import com.music.school.dto.EmailNotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

//TODO can we delete this api and add its method to other apis?
@RestController
public class HomeResource {

//@Autowired
//private SingInStudentService singInStudentService;

@Autowired
private SchedulerService schedulerService;

@Autowired
private EmailService emailService;

@Autowired
private SmsService smsService;

//    @Autowired
//    private RegistrationService registrationService;

//    @Autowired
//    private ScheduledTasks scheduledTasks;
//
//    @PostMapping(value = "/api/selectNotifier")
//    public ClientDto register(@Valid @RequestBody ClientDto clientDto) {
//
//        return registrationService.selectNotification(clientDto);
//
//    }




@PostMapping("/setSch")
public Optional<SchedulerDto> initSchedulers(@RequestBody Scheduler scheduler) {
	return schedulerService.save(scheduler);
}


@PostMapping("/emailMes")
public Optional<EmailNotificationDto> emailMessageType(@RequestBody EmailNotification emailNotification) {
	return emailService.save(emailNotification);
}


@PostMapping("/smsMes")
public Optional<SmsNotificationDto> smsMessageType(@RequestBody SmsNotification smsNotification) {
	return smsService.save(smsNotification);
	
}

@PostMapping(value = "/loginProcessingUrl")
public String newStudent() {
	
	return ("redirect:/index.html");
	
}
}
