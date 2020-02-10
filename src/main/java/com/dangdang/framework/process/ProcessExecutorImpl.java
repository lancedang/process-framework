// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.process;

import com.dangdang.framework.business.BusinessAction;
import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.config.ProcessConfig;
import com.dangdang.framework.router.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * ProcessExecutor执行器使用流程配置-ProcessConfig执行逻辑
 * ProcessExecutor利用Spring bean属性找到具体Action
 *
 * @author qiankai07
 * @version 1.0
 * Created on 2/9/20 8:22 PM
 **/
public class ProcessExecutorImpl implements ProcessExecutor {

    @Autowired
    private ApplicationContext applicationContext;

    public void execute(ProcessContext processContext) {

        String currentStage = processContext.getCurrentStage();
        ProcessConfig processConfig = processContext.getProcessConfig();

        List<String> actions = processConfig.getActionsByStage(currentStage);
        String routerName = processConfig.getRouterByStage(currentStage);

        for (String action : actions) {
            BusinessAction bean = (BusinessAction) applicationContext.getBean(action);
            bean.process(processContext);
        }

        Router router = (Router) applicationContext.getBean(routerName);
        router.route(processContext);

        this.execute(processContext);

    }

}