// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.integration;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.process.ProcessExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 5:40 PM
 **/

@Configuration
@ImportResource(locations = {"classpath:process-executor.xml"})
public class ProcessTest {

    @Autowired
    private ProcessExecutor processExecutor;

    public void test() {
        ProcessContext processContext = new ProcessContext();

    }

}