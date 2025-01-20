// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.router;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.constant.ProcessStageEnum;
import com.dangdang.framework.process.ProcessStage;

/**
 * @author qiankai07 定义所有action所属阶段的执行顺序
 * 2个层级：若干个阶段，每个阶段若干个action, 定义当前阶段之后，下层执行哪个阶段，进而确定下层action执行哪个阶段
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