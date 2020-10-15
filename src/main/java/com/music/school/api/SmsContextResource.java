package com.music.school.api;


import com.music.school.domain.SmsNotification;
import com.music.school.dto.SmsNotificationDto;
import com.music.school.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/smsContext")
public class SmsContextResource {

    @Autowired
    private SmsService smsService;

    @GetMapping
    public List<Optional<SmsNotificationDto>> getAll() {
        return smsService.getAll();
    }

    @PostMapping
    public Optional<SmsNotificationDto> save(@RequestBody SmsNotification smsNotification) {
        return smsService.save(smsNotification);
    }
    
    
}
