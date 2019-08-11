package com.github.nicejing.activiti.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jing Zhi Bao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration(locations = "classpath:activiti-context.xml")
public class ConfigSpringTest {
    @Rule
    @Autowired
    public ActivitiRule activitiRule;

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;


    @Test
    @Deployment(resources = "my-process.bpmn20.xml")
    public void test() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("my-process");
        System.out.print(processInstance.getName());
        Task task = taskService.createTaskQuery().singleResult();
        System.out.println(task.getName());
    }
}
