// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.actions;

import com.dangdang.framework.business.BusinessAction;
import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.model.DataEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/11/20 3:57 PM
 **/
public class PrepareFileAction implements BusinessAction {
    @Override
    public void process(ProcessContext processContext) {
        DataEntity dataObject = (DataEntity)processContext.getDataObject();
        System.out.println(this.getClass().getName() + "---" + dataObject.getDataHouse().get("fileName"));

        Map<String, String> data = new HashMap<String, String>();
        data.put("stage", "prepare");
        ((DataEntity) processContext.getDataObject()).loadData(data);

    }
}