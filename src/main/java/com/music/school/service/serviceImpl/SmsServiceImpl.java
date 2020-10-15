package com.music.school.service.serviceImpl;


import com.music.school.domain.Notification;
import com.music.school.domain.SmsNotification;
import com.music.school.dto.SmsNotificationDto;
import com.music.school.repository.SmsContextRepository;
import com.music.school.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsContextRepository smsContextRepository;

    @Override
    public Optional<SmsNotificationDto> getById(Integer id) {

        Optional<Notification> optionalSmsNotification = smsContextRepository.findById(id);
        if (optionalSmsNotification.isPresent()) {
            return SmsNotificationDto.smsNotificationToSmsNotificationDto((SmsNotification) optionalSmsNotification.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Optional<SmsNotificationDto>> getAll() {

        return SmsNotificationDto.smsNotificationToSmsNotificationDto(smsContextRepository.findAll());
    }

    @Override
    public Optional<SmsNotificationDto> save(SmsNotification smsNotification) {
        SmsNotification savedNotification = smsContextRepository.save(smsNotification);
        return SmsNotificationDto.smsNotificationToSmsNotificationDto(savedNotification);
    }

    @Override
    public void delete(SmsNotification smsNotification) {
        smsContextRepository.delete(smsNotification);
    }
}

