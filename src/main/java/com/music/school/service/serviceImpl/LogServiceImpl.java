package com.music.school.service.serviceImpl;

import com.music.school.domain.Log;
import com.music.school.repository.LogRepository;
import com.music.school.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {
@Autowired
private LogRepository logRepository;

@Override
public Optional<Log> save(Log auditLog) {
	Log saveLog = logRepository.save(auditLog);
	return Optional.ofNullable(saveLog);
}
}
