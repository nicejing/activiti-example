package com.github.nicejing.activiti.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.impl.interceptor.AbstractCommandInterceptor;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandConfig;

/**
 * @author Jing Zhi Bao
 */
@Slf4j
public class DurationCommandInvoker extends AbstractCommandInterceptor {

    @Override
    public <T> T execute(CommandConfig config, Command<T> command) {
        long start = System.currentTimeMillis();
        try {
            return this.next.execute(config, command);
        } finally {
            long duration = System.currentTimeMillis() - start;
            log.info("{} 执行时长为：{}", command.getClass().getSimpleName(), duration);
        }
    }
}
