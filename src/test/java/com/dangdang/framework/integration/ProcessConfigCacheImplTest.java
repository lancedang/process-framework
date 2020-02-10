// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.integration;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.cache.ProcessConfigCache;
import com.dangdang.framework.cache.ProcessConfigCacheImpl;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 10:30 PM
 **/
public class ProcessConfigCacheImplTest {

    @Test
    public void testGetProcessConfig() {
        ProcessConfigCacheImpl processConfigCache = new ProcessConfigCacheImpl();

        Resource resource = new ClassPathResource("");

        //获取classpath下所有json文件
        //processConfigCache.setResources();

        ProcessContext processContext = new ProcessContext();

        processContext.setBusinessCode("file");
        processContext.setProductCode("upload");

        processConfigCache.getProcessConfig(processContext);

    }


}