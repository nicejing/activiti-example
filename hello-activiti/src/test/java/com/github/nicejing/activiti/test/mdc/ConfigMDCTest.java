package com.github.nicejing.activiti.test.mdc;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.logging.LogMDC;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class ConfigMDCTest {

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule("activiti_mdc.cfg.xml");

    @Test
    @Deployment(resources = "my-process.bpmn20.xml")
    public void test(){

        // 需要设置logback mdc字段
        LogMDC.setMDCEnabled(true);

        activitiRule.getProcessEngine();

        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("my-process");
        System.out.print(processInstance.getName());
        Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
        System.out.println(task.getName());
    }
}
