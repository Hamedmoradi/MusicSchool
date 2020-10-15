package com.music.school.api;

import com.music.school.domain.NotificationMessageType;
import com.music.school.dto.NotificationMessageTypeDto;
import com.music.school.exception.NotificationTypeNotSelectedException;
import com.music.school.service.NotificationMessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/notificationMessageType")
public class NotificationMessageTypeResource {


    @Autowired
    private NotificationMessageTypeService notificationMessageTypeService;

    @GetMapping
    public List<Optional<NotificationMessageTypeDto>> getAll() {
        return notificationMessageTypeService.getAll();
    }

    @PostMapping
    public Optional<NotificationMessageTypeDto> save(@RequestBody NotificationMessageType notificationMessageType) {
        return notificationMessageTypeService.save(notificationMessageType);
    }
    @RequestMapping
    public ResponseEntity<Object> determineSelectedService() {
        throw new NotificationTypeNotSelectedException();
    }
}
