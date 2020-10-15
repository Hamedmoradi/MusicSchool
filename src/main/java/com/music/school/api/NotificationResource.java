package com.music.school.api;


import com.music.school.domain.Student;
import com.music.school.dto.ClientDto;
import com.music.school.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NotificationResource {
@Autowired
private NotificationService notificationService;

@PostMapping(value = "/api/notificationMessageForStudent")
public void createNotificationMessage(@Valid @RequestBody ClientDto clientDto, Student student) {
	notificationService.createNotificationMessage(clientDto, student);
}

}
