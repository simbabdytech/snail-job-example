package com.example.listener;

import com.aizuda.snailjob.client.core.event.SnailJobListener;


public class MySnailJobListener implements SnailJobListener {

    @Override
    public void beforeRetry(String sceneName, String executorClassName, Object[] params) {

    }

    @Override
    public void successOnRetry(Object result, String sceneName, String executorClassName) {

    }

    @Override
    public void failureOnRetry(String sceneName, String executorClassName, Throwable e) {

    }
}
