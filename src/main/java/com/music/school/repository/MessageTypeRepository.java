package com.music.school.repository;

import com.music.school.domain.NotificationMessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageTypeRepository extends JpaRepository<NotificationMessageType, Integer> {
    Optional<NotificationMessageType> findById(Integer id);


    @Query(value = "select c.email_address from student c join notification_message_type nmt on c.id = nmt.student_id" +
            " where c.national_code=:na_co and nmt.type=:e_type and nmt.is_active=:active", nativeQuery = true)
    String findBystudentId_EmailAddress(@Param("na_co") String nationalCode, @Param("e_type") String type, @Param("active") Boolean active);

    @Query(value = "select c.cell_phone from student c join notification_message_type nmt on c.id = nmt.student_id" +
            " where c.national_code=:na_co and nmt.type=:e_type and nmt.is_active=:active", nativeQuery = true)
    String findBystudentId_Cellphone(@Param("na_co") String nationalCode, @Param("e_type") String type, @Param("active") Boolean active);
}

