package com.example.listener;

import com.aizuda.snailjob.client.common.event.SnailClientStartingEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SnailJobStartingListener implements ApplicationListener<SnailClientStartingEvent> {
    @Override
    public void onApplicationEvent(SnailClientStartingEvent event) {
        SnailJobLog.LOCAL.info("这是一个SnailJob启动事件");
    }
}

