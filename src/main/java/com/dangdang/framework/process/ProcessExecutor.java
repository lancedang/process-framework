package com.dangdang.framework.process;

import com.dangdang.framework.business.ProcessContext;

public interface ProcessExecutor {
    void execute(ProcessContext processContext);
}
