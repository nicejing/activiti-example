package com.github.nicejing.activiti.event;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class ProcessEventListener implements ActivitiEventListener {
    @Override
    public void onEvent(ActivitiEvent event) {
        ActivitiEventType eventType = event.getType();
        if(ActivitiEventType.PROCESS_STARTED == eventType){
            log.info("流程启动 :{}", event.getProcessDefinitionId());
        }else if(ActivitiEventType.PROCESS_COMPLETED == eventType){
            log.info("流程结束 :{}", event.getProcessDefinitionId());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
