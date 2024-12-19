package com.example.job;

import com.aizuda.snailjob.client.job.core.MapHandler;
import com.aizuda.snailjob.client.job.core.dto.MapArgs;
import com.aizuda.snailjob.client.job.core.executor.AbstractMapExecutor;
import com.aizuda.snailjob.client.model.ExecuteResult;
import com.aizuda.snailjob.common.core.constant.SystemConstants;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;


@Component
public class TestMyMapExecutor extends AbstractMapExecutor {

    @Override
    public ExecuteResult doJobMapExecute(MapArgs mapArgs, MapHandler mapHandler) {
        if (SystemConstants.ROOT_MAP.equals(mapArgs.getTaskName())) {
            return mapHandler.doMap(Lists.newArrayList("1", "2", "3", "4"), "TWO_MAP");
        }

        return ExecuteResult.success(mapArgs.getMapResult());
    }

}
