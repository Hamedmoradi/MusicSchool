package com.music.school.api;

import com.music.school.dto.SchedulerDto;
import com.music.school.domain.Scheduler;
import com.music.school.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulersResource {

    @Autowired
    private SchedulerService schedulerService;

    @GetMapping
    public List<Optional<SchedulerDto>> getAll() {
        return schedulerService.getAll();
    }

    @PostMapping
    public Optional<SchedulerDto> save(@RequestBody Scheduler scheduler) {
        return schedulerService.save(scheduler);
    }


}
