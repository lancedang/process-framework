// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.actions;

import com.dangdang.framework.business.BusinessAction;
import com.dangdang.framework.business.ProcessContext;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 2/11/20 3:57 PM
 **/
public class PrepareFileAction implements BusinessAction {
    @Override
    public void process(ProcessContext processContext) {
        System.out.println(this.getClass().getName());
    }
}