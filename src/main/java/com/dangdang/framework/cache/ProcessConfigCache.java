// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.cache;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.config.ProcessConfig;

/**
 * 对外提供获取ProcessConfig的接口
 *
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 7:13 PM
 **/
public interface ProcessConfigCache {
    ProcessConfig getProcessConfig(ProcessContext processContext);
}