package com.github.nicejing.activiti.test.config;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @author jing zhi bao
 */
@Slf4j
public class ConfigTest {

    @Test
    public void configTest1() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        log.info("configuration = {}", configuration);
    }

    @Test
    public void configTest2(){
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        log.info("configuration = {}", configuration);
    }
}
