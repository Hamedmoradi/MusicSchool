package com.music.school.service;

import com.music.school.domain.Student;
import com.music.school.dto.ClientDto;

public interface RegistrationService {

    ClientDto selectNotification(ClientDto clientDto);

    Student validateNewstudent(ClientDto clientDto);

    boolean checkSelectedItem(ClientDto clientDto);
}