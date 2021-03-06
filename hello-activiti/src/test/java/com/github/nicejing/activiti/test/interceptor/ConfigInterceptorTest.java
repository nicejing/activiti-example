package com.github.nicejing.activiti.test.interceptor;

import lombok.extern.slf4j.Slf4j;
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
public class ConfigInterceptorTest {

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule("activiti_interceptor.cfg.xml");

    @Test
    @Deployment(resources = "my-process.bpmn20.xml")
    public void test() {
        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("my-process");
        System.out.print(processInstance.getName());
        Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
        System.out.println(task.getName());
    }
}
