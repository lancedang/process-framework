// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.business;

import com.dangdang.framework.config.ProcessConfig;
import com.dangdang.framework.constant.ProcessStageEnum;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/9/20 8:14 PM
 **/
public class ProcessContext {

    //定义当前执行阶段
    private String currentStage = ProcessStageEnum.INIT.name();

    private ProcessConfig processConfig;


    public String getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;
    }

    public ProcessConfig getProcessConfig() {
        return processConfig;
    }

    public void setProcessConfig(ProcessConfig processConfig) {
        this.processConfig = processConfig;
    }
}