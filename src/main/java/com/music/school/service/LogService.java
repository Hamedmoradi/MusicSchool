package com.music.school.service;

import com.music.school.domain.Log;

import java.util.Optional;

public interface LogService {
Optional<Log> save(Log log);
}
