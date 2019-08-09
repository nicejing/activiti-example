package com.github.nicejing.activiti.hello;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jing zhi bao
 */
@Slf4j
public class DemoMain {

    public static void main(String[] args) {
        log.info("启动我们的程序");
        // 创建流程引擎
        ProcessEngine processEngine = getProcessEngine();
        // 部署流程定义文件
        ProcessDefinition processDefinition = getProcessDefinition(processEngine);

        // 启动流程
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());
        log.info("启动流程 [{}]", processInstance.getProcessDefinitionKey());

        // 处理流程任务
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery().list();

        for (Task task : taskList) {
            log.info("待处理的任务： [{}]", task.getName());
        }

        log.info("结束我们的程序");
    }

    private static ProcessDefinition getProcessDefinition(ProcessEngine processEngine) {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.addClasspathResource("sceond_approve.bpmn");
        Deployment deploy = deploymentBuilder.deploy();
        String deployId = deploy.getId();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId)
            .singleResult();
        log.info("流程定义对象：[{}]，流程id： [{}]", processDefinition, processDefinition.getId());
        return processDefinition;
    }

    private static ProcessEngine getProcessEngine() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
        ProcessEngine processEngine = cfg.buildProcessEngine();
        String name = processEngine.getName();
        String version = ProcessEngine.VERSION;
        log.info("流程引擎名称：[{}], 版本：[{}]", name, version);
        return processEngine;
    }
}
