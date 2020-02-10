package com.dangdang.framework.config;

import java.util.List;

/**
 * 以stage为查询对象获取相应阶段所有Actions
 * Author: 柏云鹏
 * Date: 2/10/20.
 */
public interface ProcessConfig {
    List<String> getActionsByStage(String stage);

    String getRouterByStage(String stage);
}
