// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.process;

import com.dangdang.framework.business.BusinessAction;

import java.util.List;

/**
 * ProcessStage封装：
 * 1.每个阶段包含的Action（子任务）；
 * 2.每个阶段所使用的Router（Router作用是不通Stage之间的导航器，比如从INIT阶段转到PROGRESS阶段，当然导航逻辑自定义）
 *
 * @author qiankai07
 * @version 1.0
 * Created on 2/9/20 9:04 PM
 **/
public class ProcessStage {
    private List<String> actions;

    private String router = "defaultRouter";

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }
}