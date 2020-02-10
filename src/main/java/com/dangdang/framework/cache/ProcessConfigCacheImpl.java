// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.cache;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.config.ProcessConfig;
import com.dangdang.framework.config.ProcessConfigImpl;
import com.dangdang.framework.util.JsonUtil;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * processconfigcache缓存实现类，用于应用启动时缓存所有json process配置
 *
 * @author qiankai07
 * @version 1.0
 * Created on 2/10/20 7:21 PM
 **/
@Component
public class ProcessConfigCacheImpl implements ProcessConfigCache {

    //保存所有<json_file_name, ProcessConfig> 对应关系作为缓存
    private Map<String, ProcessConfig> processConfigMap;

    private Resource[] resources;

    @PostConstruct
    public void setProcessConfigMap() {

        Map<String, ProcessConfig> processConfigMap = new HashMap<String, ProcessConfig>();

        //读取所有json配置文件，以map形式作为缓存
        for (Resource resource : resources) {

            String filename = resource.getFilename();

            ProcessConfig processConfig = JsonUtil.getTestObject(filename, ProcessConfigImpl.class);

            processConfigMap.put(filename, processConfig);
        }

        this.processConfigMap = processConfigMap;
    }

    /**
     * 根据context中定义的business和product读取process配置
     *
     * @param processContext
     * @return
     */
    public ProcessConfig getProcessConfig(ProcessContext processContext) {


        try {
            String businessCode = processContext.getBusinessCode();
            String productCode = processContext.getProductCode();

            String file = businessCode + "_" + productCode + ".json";

            ProcessConfig processConfig = processConfigMap.get(file);

            return processConfig;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public Resource[] getResources() {
        return resources;
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }
}