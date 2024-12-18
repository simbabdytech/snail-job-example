package com.example.listener;

import com.aizuda.snailjob.client.common.event.SnailClientClosingEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SnailJobClosingListener implements ApplicationListener<SnailClientClosingEvent> {
    @Override
    public void onApplicationEvent(SnailClientClosingEvent event) {
        SnailJobLog.LOCAL.info("这是一个SnailJob开始关闭事件");
    }
}
