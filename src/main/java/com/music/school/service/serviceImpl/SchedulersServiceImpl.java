package com.music.school.service.serviceImpl;


import com.music.school.domain.Notification;
import com.music.school.dto.SchedulerDto;
import com.music.school.enums.MessageRegistration;
import com.music.school.enums.Status;
import com.music.school.repository.SchedulersRepository;
import com.music.school.domain.Scheduler;
import com.music.school.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulersServiceImpl implements SchedulerService {
@Autowired
private SchedulersRepository schedulersRepository;

@Override
public Optional<SchedulerDto> getById(Integer id) {
	Optional<Scheduler> optionalSchedulers = schedulersRepository.findById(id);
	if (optionalSchedulers.isPresent()) {
		return SchedulerDto.schedulersToSchedulersDto(optionalSchedulers.get());
	} else {
		return Optional.empty();
	}
}

@Override
public List<Optional<SchedulerDto>> getAll() {
	return SchedulerDto.schedulersToSchedulersDto(schedulersRepository.findAll());
}

@Override
public Optional<SchedulerDto> save(Scheduler scheduler) {
	Scheduler savedScheduler = schedulersRepository.save(scheduler);
	return SchedulerDto.schedulersToSchedulersDto(savedScheduler);
}


@Override
public void delete(Scheduler scheduler) {
	schedulersRepository.delete(scheduler);
}

public void saveSchedulerService(Notification notification, MessageRegistration serviceType, NotificationServiceImpl notificationService) {
	Scheduler scheduler = new Scheduler();
	scheduler.setStatus(Status.SUCCESS.getResultCode());//todo this is wrong ,it is must be set after running provider
	scheduler.setServiceCode(serviceType.getServiceCode());
	scheduler.setServiceName(serviceType.getServiceName());
	scheduler.setBusy(true);
	scheduler.setRequestDate(new Date());
	scheduler.setNotificationId(notification);
	save(scheduler);
}
}
