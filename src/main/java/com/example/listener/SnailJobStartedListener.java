package com.example.listener;

import com.aizuda.snailjob.client.common.event.SnailClientStartedEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SnailJobStartedListener implements ApplicationListener<SnailClientStartedEvent> {
    @Override
    public void onApplicationEvent(SnailClientStartedEvent event) {
        SnailJobLog.LOCAL.info("这是一个SnailJob启动完成事件");
    }
}
