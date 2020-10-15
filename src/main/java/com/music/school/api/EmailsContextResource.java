package com.music.school.api;

import com.music.school.domain.EmailNotification;
import com.music.school.dto.EmailNotificationDto;
import com.music.school.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emailsContext")
public class EmailsContextResource {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public List<Optional<EmailNotificationDto>> getAll() {
        return emailService.getAll();
    }

    @PostMapping
    public Optional<EmailNotificationDto> save(@RequestBody EmailNotification emailsContext) {
        return emailService.save(emailsContext);
    }
}
