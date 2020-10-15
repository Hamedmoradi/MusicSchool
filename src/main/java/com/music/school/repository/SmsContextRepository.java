

package com.music.school.repository;

import com.music.school.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmsContextRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findById(Integer Id);
}
