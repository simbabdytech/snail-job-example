package com.example.spi;

import com.aizuda.snailjob.client.core.RetrySiteSnapshotContext;
import com.alibaba.ttl.TransmittableThreadLocal;


public class TTLRetrySiteSnapshotContext<T> implements RetrySiteSnapshotContext<T> {

    private final ThreadLocal<T> threadLocal;

    public TTLRetrySiteSnapshotContext() {
        this.threadLocal = new TransmittableThreadLocal<>();
    }

    @Override
    public void set(final T value) {
        threadLocal.set(value);
    }

    @Override
    public void remove() {
        threadLocal.remove();
    }

    @Override
    public T get() {
        return threadLocal.get();
    }
}
