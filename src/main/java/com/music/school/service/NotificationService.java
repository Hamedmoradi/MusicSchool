package com.music.school.service;

import com.music.school.domain.Student;
import com.music.school.dto.ClientDto;

public interface NotificationService {
void createNotificationMessage(ClientDto clientDto, Student student);
}
