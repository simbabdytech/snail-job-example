package com.example.listener;

import com.aizuda.snailjob.client.common.event.SnailChannelReconnectEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SnailJobChannelReconnectListener implements ApplicationListener<SnailChannelReconnectEvent> {
    @Override
    public void onApplicationEvent(SnailChannelReconnectEvent event) {
        SnailJobLog.LOCAL.info("这个一个重连事件");
    }
}

