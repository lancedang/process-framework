package com.dangdang.framework.constant;


public enum ProcessStageEnum {

    INIT("初始化"),
    PRE_PROGRESS("处理前"),
    PROCESS("处理中"),
    POST_PROCESS("处理后"),
    ERROR_PROCESS("异常处理"),
    FINISH("结束");

    ProcessStageEnum(String desc) {
    }
}
