package com.example.job;

import com.aizuda.snailjob.client.job.core.annotation.JobExecutor;
import com.aizuda.snailjob.client.job.core.dto.JobArgs;
import com.aizuda.snailjob.client.model.ExecuteResult;
import com.aizuda.snailjob.common.core.util.JsonUtil;
import org.springframework.stereotype.Component;


@Component
@JobExecutor(name = "testAnnoJobExecutorSleep30s")
public class TestAnnoJobExecutorSleep30s {

    public ExecuteResult jobExecute(JobArgs jobArgs) {
        System.out.println(JsonUtil.toJsonString(jobArgs));
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ExecuteResult.success("测试成功");
    }
}
