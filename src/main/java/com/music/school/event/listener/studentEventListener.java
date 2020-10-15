package com.music.school.event.listener;

import com.music.school.domain.Log;
import com.music.school.enums.ActionType;
import com.music.school.event.studentEvent;
import com.music.school.enums.ServiceName;
import com.music.school.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class studentEventListener implements ApplicationListener<studentEvent> {
@Autowired
private LogService logService;


@Override
public void onApplicationEvent(studentEvent event) {
	System.out.println("student " + event.getMessage() + " with details : " + event.getStudent());
	Log log=new Log();
	log.setStudentId(event.getStudent());
	log.setContent("json");//TODO maybe a JSON value
	log.setServiceName(ServiceName.STUDENT_REGISTRATION.getName());
	log.setAction(ActionType.INSERT.getType());
	log.setSuccessRate(true);
//	log.setLastModifiedDate(new Date(event.getstudent().getModifiedDate()));
//	log.setLastModifiedBy(event.getstudent().getLastModifiedBy());
//	log.setCreationDate(new Date(event.getstudent().getCreatedBy()));
//	log.setCreatedBy(event.getstudent().getCreatedBy());
	logService.save(log);
	
}

@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
public void handleCustom(studentEvent event) {
	System.out.println("Handling event inside a transaction BEFORE COMMIT.");
}

}
