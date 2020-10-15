package com.music.school.scheduler;
import com.music.school.enums.MessageRegistration;
import com.music.school.providers.AbstractProviderService;

public interface ScheduledTasks {

    void sendNotification();

    void beforeRunningScheduler(String type, String[] titles);

    void doJob(String submissionType, MessageRegistration messageRegistration, String statement, String bankService, AbstractProviderService abstractProviderService);
}
