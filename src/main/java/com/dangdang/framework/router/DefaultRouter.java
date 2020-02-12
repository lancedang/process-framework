// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.router;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.constant.ProcessStageEnum;
import com.dangdang.framework.process.ProcessStage;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/9/20 8:22 PM
 **/
public class DefaultRouter implements Router {
    public void route(ProcessContext processContext) {
        String currentStage = processContext.getCurrentStage();
        if (!"FINISH".equals(currentStage)) {
            if (ProcessStageEnum.INIT.name().equals(currentStage)) {
                processContext.setCurrentStage(ProcessStageEnum.PROCESS.name());
            } else if (ProcessStageEnum.PRE_PROGRESS.name().equals(currentStage)) {
                processContext.setCurrentStage(ProcessStageEnum.PROCESS.name());
            } else if (ProcessStageEnum.PROCESS.name().equals(currentStage)) {
                processContext.setCurrentStage(ProcessStageEnum.POST_PROCESS.name());
            } else if (ProcessStageEnum.POST_PROCESS.name().equals(currentStage)) {
                processContext.setCurrentStage(ProcessStageEnum.FINISH.name());
            } else {
                processContext.setCurrentStage(ProcessStageEnum.FINISH.name());
            }
        }
    }

    @Override
    public void routeError(ProcessContext processContext) {
        processContext.setCurrentStage(ProcessStageEnum.ERROR_PROCESS.name());
    }

}