package com.dangdang.framework.router;

import com.dangdang.framework.business.ProcessContext;
import com.dangdang.framework.process.ProcessStage;

public interface Router {
    void route(ProcessContext processContext);

    void routeError(ProcessContext processContext);
}
