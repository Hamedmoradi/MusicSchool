package com.music.school.dto;


import com.music.school.domain.Scheduler;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

@XmlRootElement(name = "scheduler")
public class SchedulerDto implements Serializable {
    private Integer id;
    private Date requestDate;
    private Date dueDate;
    private Integer status;
    private Integer ServiceCode;
    private String ServiceName;
    private boolean busy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getServiceCode() {
        return ServiceCode;
    }

    public void setServiceCode(Integer serviceCode) {
        ServiceCode = serviceCode;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public static Optional<SchedulerDto> schedulersToSchedulersDto(Scheduler scheduler){
        if(scheduler != null ){
            SchedulerDto schedulerDto = new SchedulerDto();
            schedulerDto.setId(scheduler.getId());
            schedulerDto.setRequestDate(scheduler.getRequestDate());
            schedulerDto.setDueDate(scheduler.getDueDate());
            schedulerDto.setStatus(scheduler.getStatus());
            schedulerDto.setServiceName(scheduler.getServiceName());
            schedulerDto.setServiceCode(scheduler.getServiceCode());
            schedulerDto.setBusy(scheduler.isBusy());
            return Optional.of(schedulerDto);
        }else{
            return Optional.empty();
        }
    }

    public static List<Optional<SchedulerDto>> schedulersToSchedulersDto(Collection<Scheduler> schedulers) {
        if (null != schedulers && schedulers.size() > 0) {
            List<Optional<SchedulerDto>> schedulerDtoList = new ArrayList<>(schedulers.size());
            for (Scheduler scheduler : schedulers) {
                schedulerDtoList.add(schedulersToSchedulersDto(scheduler));
            }
            return schedulerDtoList;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
