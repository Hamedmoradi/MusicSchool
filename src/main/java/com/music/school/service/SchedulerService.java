package com.music.school.service;


import com.music.school.domain.Notification;
import com.music.school.domain.Scheduler;
import com.music.school.dto.SchedulerDto;
import com.music.school.enums.MessageRegistration;
import com.music.school.service.serviceImpl.NotificationServiceImpl;

import java.util.List;
import java.util.Optional;

public interface SchedulerService {

Optional<SchedulerDto> getById(Integer id);

List<Optional<SchedulerDto>> getAll();

Optional<SchedulerDto> save(Scheduler scheduler);

void delete(Scheduler scheduler);

void saveSchedulerService(Notification notification, MessageRegistration serviceType, NotificationServiceImpl notificationService);

}
