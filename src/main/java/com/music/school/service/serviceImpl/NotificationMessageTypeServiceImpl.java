package com.music.school.service.serviceImpl;

import com.music.school.dto.NotificationMessageTypeDto;
import com.music.school.exception.CommonNotFoundException;
import com.music.school.repository.MessageTypeRepository;
import com.music.school.domain.NotificationMessageType;
import com.music.school.service.NotificationMessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationMessageTypeServiceImpl implements NotificationMessageTypeService {

@Autowired
private MessageTypeRepository messageTypeRepository;

@Override
public Optional<NotificationMessageTypeDto> getById(Integer id) {
	return messageTypeRepository
			       .findById(id)
			       .map(NotificationMessageTypeDto::notificationMessageTypeToDto)
			       .orElseThrow(CommonNotFoundException::new);
}

@Override
public List<Optional<NotificationMessageTypeDto>> getAll() {
	return NotificationMessageTypeDto.notificationMessageTypeToDto(messageTypeRepository.findAll());
	
}

@Override
public Optional<NotificationMessageTypeDto> save(NotificationMessageType notificationMessageType) {
	NotificationMessageType savedNotificationMessageType = messageTypeRepository.save(notificationMessageType);
	return NotificationMessageTypeDto.notificationMessageTypeToDto(savedNotificationMessageType);
}

@Override
public void delete(NotificationMessageType notificationMessageType) {
	messageTypeRepository.delete(notificationMessageType);
}

@Override
public String getEmailBystudentId(Optional<NotificationMessageTypeDto> notificationMessageTypeDto) {
	return messageTypeRepository.findBystudentId_EmailAddress(notificationMessageTypeDto.get().getStudentId().getNationalCode(),
			notificationMessageTypeDto.get().getType(), notificationMessageTypeDto.get().isActive());
}

@Override
public String getSmsByStudentId(Optional<NotificationMessageTypeDto> notificationMessageTypeDto) {
	return messageTypeRepository.findBystudentId_Cellphone(notificationMessageTypeDto.get().getStudentId().getNationalCode(),
			notificationMessageTypeDto.get().getType(), notificationMessageTypeDto.get().isActive());
}

}
