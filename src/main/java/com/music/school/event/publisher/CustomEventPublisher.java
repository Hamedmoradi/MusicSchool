package com.music.school.event.publisher;

import com.music.school.domain.Student;
import com.music.school.event.studentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class CustomEventPublisher  implements ApplicationEventPublisherAware {

@Autowired
private ApplicationEventPublisher publisher;


public void setApplicationEventPublisher (ApplicationEventPublisher publisher) {
	this.publisher = publisher;
}

public void publish(final String message, final Student student) {
	System.out.println("Publishing custom event.");
	studentEvent ce = new studentEvent(this,message, student);
	publisher.publishEvent(ce);
}
}
