// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.integration;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.cache.ProcessConfigCacheImpl;
import com.dangdang.framework.config.ProcessConfig;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 10:30 PM
 **/
public class ProcessConfigCacheImplTest {

    @Test
    public void testGetProcessConfig() {
        ProcessConfigCacheImpl processConfigCache = new ProcessConfigCacheImpl();

        Resource resource = new ClassPathResource("file_upload.json");

        processConfigCache.setResources((Resource[]) Arrays.asList(resource).toArray());
        processConfigCache.setProcessConfigMap();

        ProcessContext processContext = new ProcessContext();

        //设置business和product code
        processContext.setBusinessCode("file");
        processContext.setProductCode("upload");

        //设置初始化数据
        ProcessConfig processConfig = processConfigCache.getProcessConfig(processContext);

        List<String> init = processConfig.getActionsByStage("INIT");
        System.out.println(init);

    }

}