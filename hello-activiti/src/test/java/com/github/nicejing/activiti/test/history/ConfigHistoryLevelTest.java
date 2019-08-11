package com.github.nicejing.activiti.test.history;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.logging.LogMDC;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class ConfigHistoryLevelTest {


    @Rule
    public ActivitiRule activitiRule = new ActivitiRule("activiti_history.cfg.xml");

    @Test
    @Deployment(resources = "my-process.bpmn20.xml")
    public void test() {

        // 需要设置logback mdc字段
        LogMDC.setMDCEnabled(true);


        Map<String, Object> params = Maps.newHashMap();
        params.put("keyStart1", "value1");
        params.put("keyStart2", "value2");
        // 启动流程
        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("my-process", params);

        List<Execution> executions = activitiRule.getRuntimeService().createExecutionQuery().listPage(0, 100);
        for (Execution execution : executions) {
            log.info("execution = {}", execution);
        }
        log.info("execution.size =  {}", executions.size());

        // 修改变量
        String id = executions.iterator().next().getId();
        activitiRule.getRuntimeService().setVariable(id, "keyStart1", "value1_new");


        Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
        // 输出历史内容
        // 输出历史活动
        List<HistoricActivityInstance> historicActivityInstances = activitiRule.getHistoryService().createHistoricActivityInstanceQuery().listPage(0, 100);
        for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
            log.info("historicActivityInstance = {}", historicActivityInstance);
        }
        // 历史详情

        // 历史表单

    }


}
