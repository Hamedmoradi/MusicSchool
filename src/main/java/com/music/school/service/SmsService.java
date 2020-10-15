package com.music.school.service;


import com.music.school.domain.SmsNotification;
import com.music.school.dto.SmsNotificationDto;

import java.util.List;
import java.util.Optional;


public interface SmsService {
    Optional<SmsNotificationDto> getById(Integer id);

    List<Optional<SmsNotificationDto>> getAll();

    Optional<SmsNotificationDto> save(SmsNotification smsNotification);

    void delete(SmsNotification smsNotification);
}
