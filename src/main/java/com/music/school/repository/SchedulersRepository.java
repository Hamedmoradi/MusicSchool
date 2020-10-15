package com.music.school.repository;

import com.music.school.domain.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchedulersRepository extends JpaRepository<Scheduler,Integer> {
    Optional<Scheduler> findById(Integer id);
}
