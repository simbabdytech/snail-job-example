package com.example.listener;

import com.aizuda.snailjob.client.common.event.SnailClientClosedEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SnailJobClosedListener implements ApplicationListener<SnailClientClosedEvent> {
    @Override
    public void onApplicationEvent(SnailClientClosedEvent event) {
        SnailJobLog.LOCAL.info("这是一个SnailJob关闭完成事件");
    }
}
