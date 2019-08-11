package com.github.nicejing.activiti.test.event;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.event.EventLogEntry;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class ConfigEventLogTest {

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule("activiti_eventlog.cfg.xml");

    @Test
    @Deployment(resources = "my-process.bpmn20.xml")
    public void test() {

        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("my-process");

        List<EventLogEntry> eventLogEntries = activitiRule.getManagementService().getEventLogEntriesByProcessInstanceId(processInstance.getId());
        for (EventLogEntry eventLogEntry : eventLogEntries) {
            log.info("eventLogEntry type = {},data= {}", eventLogEntry.getType(),eventLogEntry.getData());
        }
        System.out.print(processInstance.getName());
        Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
        System.out.println(task.getName());
    }
}
