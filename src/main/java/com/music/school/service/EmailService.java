package com.music.school.service;



import com.music.school.domain.EmailNotification;
import com.music.school.dto.EmailNotificationDto;

import java.util.List;
import java.util.Optional;

public interface EmailService {
    Optional<EmailNotificationDto> getById(Integer id);

    List<Optional<EmailNotificationDto>> getAll();

    Optional<EmailNotificationDto> save(EmailNotification emailsContext);

    void delete(EmailNotification emailsContext);
}
