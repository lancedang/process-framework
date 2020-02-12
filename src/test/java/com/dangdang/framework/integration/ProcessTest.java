// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.integration;

import com.dangdang.framework.Main;
import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.cache.ProcessConfigCache;
import com.dangdang.framework.config.ProcessConfig;
import com.dangdang.framework.model.DataEntity;
import com.dangdang.framework.process.ProcessExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 5:40 PM
 **/

/**
 * 测试类使用src.main.java下的SpringBoot环境
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ProcessTest {

    @Autowired
    private ProcessExecutor processExecutor;

    @Autowired
    private ProcessConfigCache processConfigCache;

    @Test
    public void test() {
        ProcessContext processContext = new ProcessContext();

        //设置business和product code
        processContext.setBusinessCode("file");
        processContext.setProductCode("upload");

        //设置初始化数据
        DataEntity dataEntity = new DataEntity();
        Map<String, String> data = new HashMap<String, String>();
        data.put("fileName", "wenjian");
        dataEntity = dataEntity.loadData(data);

        processContext.setDataObject(dataEntity);

        ProcessConfig processConfig = processConfigCache.getProcessConfig(processContext);

        processContext.setProcessConfig(processConfig);

        processExecutor.execute(processContext);


    }

}