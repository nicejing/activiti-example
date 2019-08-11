package com.github.nicejing.activiti.event;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class CustomEventListener implements ActivitiEventListener {
    @Override
    public void onEvent(ActivitiEvent event) {
        ActivitiEventType eventType = event.getType();
        if(ActivitiEventType.CUSTOM == eventType){
            log.info("监听到自定义的事件类型 :{}", event.getProcessDefinitionId());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
