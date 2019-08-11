package com.github.nicejing.activiti.test.job;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class ConfigJobTest {

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule("activiti_job.cfg.xml");

    @Test
    @Deployment(resources = "my-process.bpmn20.xml")
    public void test() {

    }
}
