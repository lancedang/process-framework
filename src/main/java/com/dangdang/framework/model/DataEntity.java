// Copyright (C) 2020 Meituan
// All rights reserved
package com.dangdang.framework.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 作为ProcessContext的属性传递action所需参数
 *
 * @author qiankai07
 * @version 1.0
 * Created on 2/12/20 1:57 PM
 **/
public class DataEntity {
    private Map<String, String> dataHouse = new HashMap<String, String>(32);


    public Map<String, String> getDataHouse() {
        return dataHouse;
    }

    public void setDataHouse(Map<String, String> dataHouse) {
        this.dataHouse = dataHouse;
    }

    public DataEntity loadData(Map<String, String> dataHouse) {
        this.dataHouse.putAll(dataHouse);
        return this;
    }
}