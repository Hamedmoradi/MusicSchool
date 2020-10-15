package com.music.school.service.serviceImpl;

import com.music.school.domain.EmailNotification;
import com.music.school.domain.Notification;
import com.music.school.dto.EmailNotificationDto;
import com.music.school.repository.EmailsContextRepository;
import com.music.school.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailsContextRepository emailsContextRepository;


    @Override
    public Optional<EmailNotificationDto> getById(Integer id) {
        Optional<Notification> optionalEmailNotification = emailsContextRepository.findById(id);
        if (optionalEmailNotification.isPresent()) {
            return EmailNotificationDto.emailNotificationToEmailNotificationDto((EmailNotification) optionalEmailNotification.get());
        } else {
            return Optional.empty();
        }
    }


    @Override
    public List<Optional<EmailNotificationDto>> getAll() {
        return EmailNotificationDto.emailNotificationToEmailNotificationDto(emailsContextRepository.findAll());
    }

    @Override
    public Optional<EmailNotificationDto> save(EmailNotification emailNotification) {
        EmailNotification savedNotification = emailsContextRepository.save(emailNotification);
        return EmailNotificationDto.emailNotificationToEmailNotificationDto(savedNotification);
    }

    @Override
    public void delete(EmailNotification emailsContext) {
        emailsContextRepository.delete(emailsContext);
    }




}
