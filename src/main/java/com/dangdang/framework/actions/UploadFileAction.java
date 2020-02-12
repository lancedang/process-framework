// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.actions;

import com.dangdang.framework.business.BusinessAction;
import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.model.DataEntity;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/11/20 3:59 PM
 **/
public class UploadFileAction implements BusinessAction {
    @Override
    public void process(ProcessContext processContext) {
        //throw new RuntimeException("upload failure");
        System.out.println(this.getClass().getName() + "---" + ((DataEntity)processContext.getDataObject()).getDataHouse().get("stage"));
    }
}