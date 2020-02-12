// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.config;

import com.dangdang.framework.process.ProcessStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 从processStageMap配置中获得相应actions和Router
 *
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 11:50 AM
 **/
public class ProcessConfigImpl implements ProcessConfig {


    private Map<String, ProcessStage> processStageMap;

    public List<String> getActionsByStage(String stage) {

        ProcessStage processStage = processStageMap.get(stage);
        List<String> actions = processStage == null? new ArrayList<String>(): processStage.getActions();

        return actions;
    }

    public String getRouterByStage(String stage) {

        ProcessStage processStage = processStageMap.get(stage);
        String router = processStage == null? "defaultRouter" :processStage.getRouter();

        return router;
    }

    public Map<String, ProcessStage> getProcessStageMap() {
        return processStageMap;
    }

    public void setProcessStageMap(Map<String, ProcessStage> processStageMap) {
        this.processStageMap = processStageMap;
    }
}