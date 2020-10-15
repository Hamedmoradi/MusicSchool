package com.music.school.service;

import com.music.school.dto.NotificationMessageTypeDto;
import com.music.school.domain.NotificationMessageType;

import java.util.List;
import java.util.Optional;

public interface NotificationMessageTypeService {

    Optional<NotificationMessageTypeDto> getById(Integer id);

    List<Optional<NotificationMessageTypeDto>> getAll();

    Optional<NotificationMessageTypeDto> save(NotificationMessageType notificationMessageType);

    void delete(NotificationMessageType notificationMessageType);

    String getEmailBystudentId(Optional<NotificationMessageTypeDto> notificationMessageTypeDto);

    String getSmsByStudentId(Optional<NotificationMessageTypeDto> notificationMessageTypeDto);
}
