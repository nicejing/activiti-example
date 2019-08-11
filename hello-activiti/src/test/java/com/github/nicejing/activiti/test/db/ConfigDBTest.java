package com.github.nicejing.activiti.test.db;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class ConfigDBTest {

    @Test
    public void configDBTest1() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti_druid.cfg.xml");
        log.info("configuration = {}", configuration);

        ProcessEngine processEngine = configuration.buildProcessEngine();

        log.info("获取流程引擎: [{}]", processEngine.getName());
        processEngine.close();
    }
}
